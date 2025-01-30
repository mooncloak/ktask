package com.mooncloak.kodetools.ktask

import kotlinx.coroutines.flow.SharedFlow

/**
 * Represents a component that can schedule and perform tasks.
 *
 * The TaskService interface is responsible for managing task scheduling, execution, and lifecycle.
 * It extends the [ServiceLifecycle] interface, providing additional functionalities to control the service's life
 * cycle. [TaskService] handles tasks through queues, enqueuing tasks with specific configurations, and observing state
 * changes.
 */
@ExperimentalTaskApi
public interface TaskService : ServiceLifecycle,
    TaskQueue {

    /**
     * A shared flow that emits events related to tasks managed by the [TaskService].
     *
     * The [events] flow provides a stream of [TaskEvent]`s that represent changes in the state of tasks within the
     * service. Subscribers to this flow can observe various task-related events, such as when a task is scheduled,
     * removed, executing, completed, or failed. Each type of [TaskEvent] carries specific details relevant to the
     * event type.
     *
     * This property allows consumers to react to task state changes, enabling further integration or logging based on
     * task lifecycle events.
     *
     * @see TaskEvent
     */
    public val events: SharedFlow<TaskEvent>

    public companion object
}
