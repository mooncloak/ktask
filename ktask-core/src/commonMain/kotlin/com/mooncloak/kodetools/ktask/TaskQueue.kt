package com.mooncloak.kodetools.ktask

import kotlin.coroutines.cancellation.CancellationException
import kotlin.time.Duration
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

/**
 * Represents a task queue, enabling tasks to be added, retrieved, and managed. Tasks in the queue can be identified
 * through unique identifiers. The queue supports operations such as enqueuing, removing a task, clearing the queue,
 * and retrieving tasks.
 */
@ExperimentalTaskApi
public interface TaskQueue {

    /**
     * The current number of tasks in the queue.
     *
     * Represents the total count of tasks that are currently enqueued and waiting to be processed.
     */
    public val size: Int

    /**
     * Checks if the task queue is empty.
     *
     * @return `true` if the queue contains no tasks, otherwise `false`.
     */
    public fun isEmpty(): Boolean = size == 0

    /**
     * Determines whether the task queue contains a task with the specified unique identifier.
     *
     * @param [id] The unique identifier of the task to check for.
     *
     * @return `true` if a task with the specified identifier exists in the task queue, otherwise `false`.
     */
    public operator fun contains(id: String): Boolean

    /**
     * Retrieves a [Task] from the task queue with the specified unique identifier.
     *
     * @param [id] The unique identifier of the [Task] to retrieve.
     *
     * @throws [NoSuchElementException] If no [Task] with the specified identifier is found in the task queue.
     *
     * @throws [CancellationException] If the operation is canceled.
     *
     * @return The [Task] associated with the given identifier.
     */
    @Throws(NoSuchElementException::class, CancellationException::class)
    public operator fun get(id: String): Task

    /**
     * Retrieves all tasks currently present in the task queue.
     *
     * > [!Note]
     * > The order of the [Task]s in the returned [List] does NOT indicate the execution order of the [Task]s.
     *
     * @return A list of all tasks in the queue. If the queue is empty, an empty list is returned.
     */
    public fun getAll(): List<Task>

    /**
     * Adds the specified [task] to the task queue for scheduled execution.
     *
     * @param [task] The [Task] to be added to the queue.
     *
     * @return The enqueued [Task]. Note that the returned [Task] might be different from the provided [task] value
     * because the [Task.scheduled] property would be overwritten.
     */
    public suspend fun enqueue(task: Task): Task

    /**
     * Creates a [Task] from the provided values and adds it to the queue to be invoked.
     *
     * @param [id] The unique identifier of the [Task]. If a [Task] exists in the queue with the same identifier value,
     * that [Task] will be removed, and not invoked, before this one is added.
     *
     * @param [type] The type of this [Task]. If a [Task] exists in the queue with the same type value, that [Task]
     * will be removed, and not invoked, before this one is added.
     *
     * @param [delay] The [Duration] to wait from the moment this [Task] was scheduled for it to be invoked. If this
     * value is `null`, then the [Task] will be invoked whenever it is retrieved from the queue without a timeout
     * delay.
     *
     * @param [interval] The [Duration] between subsequent invocations of this [Task]. If this [Task] is to be invoked
     * more than once, this value determines the [Duration] in between each running of this task. If this value is
     * `null`, then the [Task] will only be invoked at most once. This value is used in unison with the [replay] value.
     * Defaults to `null`.
     *
     * @param [replay] The amount of times this [Task] should be invoked. If this value is less than zero and
     * [interval] was set, the task should be invoked indefinitely. If this value is zero, the task will only be
     * invoked the first time and will ot be replayed. Otherwise, the value will be replayed this amount of times.
     * Defaults to zero.
     *
     * @param [value] The function that performs the [Task] logic that will be invoked when it is retrieved from the
     * queue by the [TaskService].
     *
     * @return The newly created and enqueued [Task].
     */
    @OptIn(ExperimentalUuidApi::class)
    public suspend fun enqueue(
        id: String = Uuid.random().toHexString(),
        type: String? = null,
        delay: Duration? = null,
        interval: Duration? = null,
        replay: Int = 0,
        value: suspend () -> Unit
    ): Task

    /**
     * Removes the [Task] with the provided [id] from the task queue.
     *
     * @param [id] The [Task.id] of the [Task] to be removed.
     *
     * @return `true` if the [Task] with the provided [id] exists in and was removed from the task queue, `false`
     * otherwise.
     */
    public suspend fun remove(id: String): Boolean

    /**
     * Clears all tasks from the task queue.
     *
     * This method removes all tasks, ensuring that the queue becomes empty. Any operations relying on the presence of
     * tasks in the queue may be affected after calling this method. It is intended to reset the task queue to an
     * initial state without any queued tasks.
     */
    public suspend fun clear()

    public companion object
}

/**
 * Safely retrieves a [Task] from the task queue by its unique identifier. If no task with
 * the specified identifier exists, this method returns `null` instead of throwing an exception.
 *
 * @param [id] The unique identifier of the [Task] to retrieve.
 *
 * @return The [Task] associated with the given identifier, or `null` if no such task exists.
 */
@ExperimentalTaskApi
public fun TaskQueue.getOrNull(id: String): Task? =
    try {
        get(id)
    } catch (e: NoSuchElementException) {
        null
    }
