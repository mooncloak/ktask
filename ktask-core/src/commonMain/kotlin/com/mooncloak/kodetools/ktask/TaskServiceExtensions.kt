package com.mooncloak.kodetools.ktask

import kotlin.time.Duration
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

/**
 * Adds the specified task to the task service's queue for execution.
 *
 * @param [task] The task to be enqueued, containing its associated properties and action to be executed.
 *
 * @return `true` if the [enqueue] function was launched (see [ServiceLifecycle.runInScope]), `false` otherwise.
 *
 * @see [ServiceLifecycle.runInScope]
 * @see [TaskQueue.enqueue]
 */
@ExperimentalTaskApi
public fun TaskService.launchEnqueue(task: Task): Boolean =
    runInScope { enqueue(task) }

/**
 * Launches and enqueues a task for execution using the task service.
 *
 * This method wraps the [TaskQueue.enqueue] function, scheduling the provided task with the specified configuration
 * parameters. The task will be executed within the service's coroutine scope if the scope is active.
 *
 * @param [id] The unique identifier for the task. Defaults to a randomly generated UUID.
 *
 * @param [type] An optional type or category for the task.
 *
 * @param [delay] The duration to wait before the task is executed after it is scheduled. Defaults to `null`.
 *
 * @param [interval] The interval between repeated executions of the task, if applicable. Defaults to `null`.
 *
 * @param [replay] The number of times to replay the task. Defaults to `0`.
 *
 * @param [value] The suspending lambda representing the logic to be executed by the task.
 *
 * @return `true` if the [remove] function was launched (see [ServiceLifecycle.runInScope]), `false` otherwise.
 *
 * @see [ServiceLifecycle.runInScope]
 * @see [TaskQueue.enqueue]
 */
@ExperimentalTaskApi
@OptIn(ExperimentalUuidApi::class)
public fun TaskService.launchEnqueue(
    id: String = Uuid.random().toHexString(),
    type: String? = null,
    delay: Duration? = null,
    interval: Duration? = null,
    replay: Int = 0,
    value: suspend () -> Unit
): Boolean = runInScope {
    enqueue(
        id = id,
        type = type,
        delay = delay,
        interval = interval,
        replay = replay,
        value = value
    )
}

/**
 * Launches the removal of a task with the specified identifier within the [TaskService] scope.
 *
 * This function ensures the removal operation is executed within the coroutine scope of [TaskService] by delegating to
 * the [TaskQueue.remove] function. The task identified by the given `id` will be removed if it exists.
 *
 * @param [id] The unique identifier of the task to be removed from the task queue.
 *
 * @return `true` if the [remove] function was launched (see [ServiceLifecycle.runInScope]), `false` otherwise.
 *
 * @see [ServiceLifecycle.runInScope]
 * @see [TaskQueue.remove]
 */
@ExperimentalTaskApi
public inline fun TaskService.launchRemove(
    id: String
): Boolean = runInScope { remove(id) }

/**
 * Launches a coroutine to clear all tasks managed by the TaskService.
 *
 * This function utilizes the [ServiceLifecycle.runInScope] method to execute the [TaskQueue.clear] operation within
 * the coroutine scope of the [TaskService]. The `clear` function, when invoked, removes all tasks from the task queue,
 * effectively resetting it to an empty state.
 *
 * The operation will only execute if the associated coroutine scope of the TaskService is active.
 *
 * @return `true` if the [clear] function was launched (see [ServiceLifecycle.runInScope]), `false` otherwise.
 *
 * @see [ServiceLifecycle.runInScope]
 * @see [TaskQueue.clear]
 */
@ExperimentalTaskApi
public inline fun TaskService.launchClear(): Boolean =
    runInScope { clear() }
