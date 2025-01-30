package com.mooncloak.kodetools.ktask

/**
 * A functional interface that represents a task scheduler designed for use with a [TaskService].
 *
 * This interface enables the definition of scheduling behaviors by implementing the `schedule` function.
 * Implementations can define custom logic to schedule tasks in the associated [TaskService].
 */
@ExperimentalTaskApi
public fun interface TaskScheduler {

    /**
     * Defines the scheduling behavior for a [TaskService].
     *
     * This method should be implemented to specify how tasks are scheduled within the context
     * of a [TaskService] instance. It allows custom scheduling logic to be applied to the associated
     * service, enabling dynamic task management.
     *
     * @receiver A [TaskService] instance that provides the context and task-related operations.
     */
    public suspend fun TaskService.schedule()

    public companion object
}

/**
 * Invokes the scheduling behavior provided by the given [TaskScheduler] within the context
 * of the current [TaskService] instance.
 *
 * @param scheduler The [TaskScheduler] defining the scheduling logic to be applied on the [TaskService].
 */
@ExperimentalTaskApi
public suspend fun TaskService.schedule(scheduler: TaskScheduler) {
    scheduler.apply {
        schedule()
    }
}

/**
 * Launches the scheduling process using the provided [TaskScheduler].
 *
 * This method applies the given scheduler to the current [TaskService]
 * instance to define task scheduling behavior. The scheduler's logic
 * is invoked within a specific enqueue context.
 *
 * @param scheduler The [TaskScheduler] instance that defines the scheduling
 * behavior to be applied to the [TaskService].
 */
@ExperimentalTaskApi
public fun TaskService.launchSchedule(scheduler: TaskScheduler) {
    launchEnqueue {
        scheduler.apply {
            schedule()
        }
    }
}
