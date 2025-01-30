package com.mooncloak.kodetools.ktask.ktor

import com.mooncloak.kodetools.ktask.*
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlinx.datetime.Clock
import kotlin.time.Duration
import kotlin.time.Duration.Companion.seconds

/**
 * A Ktor implementation of the [TaskService] interface responsible for scheduling and managing tasks.
 *
 * @constructor Creates an instance of KtorTaskService.
 *
 * @param [coroutineScope] The CoroutineScope used for coroutine context management.
 *
 * @param [clock] The clock instance used for scheduling tasks based on time.
 *
 * @param [downtimeDuration] The duration to delay the event loop when no tasks are available (default is 15 seconds).
 */
@ExperimentalTaskApi
internal class KtorTaskService internal constructor(
    private val coroutineScope: CoroutineScope,
    private val clock: Clock,
    private val downtimeDuration: Duration = 15.seconds
) : TaskService {

    override val isActive: Boolean
        get() = coroutineScope.isActive && !isClosed

    override val events: SharedFlow<TaskEvent>
        get() = mutableEvents.asSharedFlow()

    private val schedulingMutex = Mutex(locked = false)
    private val executionMutex = Mutex(locked = false)
    private val eventMutex = Mutex(locked = false)

    private val mutableTasks = mutableListOf<Task>()
    private val mutableEvents = MutableSharedFlow<TaskEvent>()

    private var isClosed = true
    private var job: Job? = null

    override val size: Int
        get() = mutableTasks.size

    override fun start(): Boolean {
        if (isClosed && coroutineScope.isActive) {
            job?.cancel()

            isClosed = false

            job = coroutineScope.launch {
                eventLoop()
            }

            return true
        }

        return false
    }

    override fun cancel() {
        if (!isClosed) {
            isClosed = true
            job?.cancel()
        }
    }

    override fun runInScope(block: suspend CoroutineScope.() -> Unit): Boolean {
        coroutineScope.launch(block = block)

        return isActive
    }

    override fun contains(id: String): Boolean =
        mutableTasks.any { task -> task.id == id }

    override fun get(id: String): Task =
        mutableTasks.first { task -> task.id == id }

    override fun getAll(): List<Task> =
        mutableTasks.toList()

    override suspend fun enqueue(task: Task): Task =
        enqueue(
            id = task.id,
            type = task.type,
            delay = task.delay,
            interval = task.interval,
            replay = task.replay,
            value = task::invoke
        )

    override suspend fun enqueue(
        id: String,
        type: String?,
        delay: Duration?,
        interval: Duration?,
        replay: Int,
        value: suspend () -> Unit
    ): Task = scheduleTask {
        Task(
            id = id,
            type = type,
            scheduled = clock.now(),
            delay = delay,
            interval = interval,
            replay = replay,
            value = value
        )
    }

    override suspend fun remove(id: String): Boolean {
        schedulingMutex.withLock {
            val tasks = mutableTasks.filter { task -> task.id == id }
            val removed = mutableTasks.removeAll(tasks)

            if (removed) {
                emitEvent(
                    event = TaskEvent.Completed(
                        action = TaskEvent.Action.REMOVE,
                        tasks = tasks,
                        duplicate = false
                    )
                )
            } else {
                emitEvent(
                    event = TaskEvent.Failed(
                        action = TaskEvent.Action.REMOVE,
                        cause = NoSuchElementException("No task found with id '$id'.")
                    )
                )
            }

            return removed
        }
    }

    override suspend fun clear() {
        schedulingMutex.withLock {
            val tasks = mutableTasks.toList()
            val removed = mutableTasks.clear()

            emitEvent(
                event = TaskEvent.Completed(
                    action = TaskEvent.Action.REMOVE,
                    tasks = tasks,
                    duplicate = false
                )
            )

            return removed
        }
    }

    private suspend fun eventLoop() {
        while (this.isActive) {
            runNextTask()
        }
    }

    private suspend fun runNextTask() {
        // Perform the next task in the task queue.
        if (mutableTasks.isNotEmpty()) {
            val now = clock.now()

            // Retrieve the next runnable task.
            val task = schedulingMutex.withLock {
                val index = mutableTasks.indexOfFirst { task -> task.isRunnableAt(now) }

                return@withLock if (index == -1) {
                    null
                } else {
                    mutableTasks.removeAt(index)
                }
            }

            // Run the task
            if (task != null) {
                executionMutex.withLock {
                    emitEvent(
                        event = TaskEvent.Running(
                            action = TaskEvent.Action.EXECUTE,
                            task = task
                        )
                    )

                    val response = runCatching {
                        task.invoke()
                    }

                    if (response.isFailure) {
                        emitEvent(
                            event = TaskEvent.Failed(
                                action = TaskEvent.Action.EXECUTE,
                                task = task,
                                cause = response.exceptionOrNull()
                            )
                        )
                    } else if (response.isSuccess) {
                        emitEvent(
                            event = TaskEvent.Completed(
                                action = TaskEvent.Action.EXECUTE,
                                task = task
                            )
                        )
                    }

                    if (task.shouldRunAgain()) {
                        val updatedTask = task.copy(
                            replay = if (task.replay > 0) {
                                task.replay - 1
                            } else {
                                task.replay
                            },
                            delay = task.interval ?: task.delay
                        )

                        coroutineScope.launch {
                            scheduleTask { updatedTask }
                        }
                    }
                }
            }
        } else {
            // There are currently no more tasks to run, so delay for the arbitrary delay period so we don't over
            // constrain system resources. After the delay, the event loop will proceed and check for more tasks.
            delay(downtimeDuration)
        }
    }

    private suspend fun emitEvent(event: TaskEvent) {
        eventMutex.withLock {
            mutableEvents.emit(event)
        }
    }

    private suspend fun scheduleTask(
        getTask: suspend () -> Task
    ): Task {
        schedulingMutex.withLock {
            // The task to add.
            val task = getTask()

            emitEvent(
                event = TaskEvent.Running(
                    task = task,
                    action = TaskEvent.Action.SCHEDULE
                )
            )

            // Remove any existing tasks that have the same id or type.
            val tasksToRemove = mutableTasks.filter {
                it.id == task.id || it.type == task.type
            }
            if (tasksToRemove.isNotEmpty()) {
                emitEvent(
                    event = TaskEvent.Running(
                        action = TaskEvent.Action.REMOVE,
                        tasks = tasksToRemove
                    )
                )
                val removed = mutableTasks.removeAll(tasksToRemove)
                if (removed) {
                    emitEvent(
                        event = TaskEvent.Completed(
                            action = TaskEvent.Action.REMOVE,
                            tasks = tasksToRemove,
                            duplicate = true
                        )
                    )
                }
            }

            // Add the new task
            mutableTasks.add(task)

            emitEvent(
                event = TaskEvent.Completed(
                    action = TaskEvent.Action.SCHEDULE,
                    task = task
                )
            )

            return task
        }
    }
}
