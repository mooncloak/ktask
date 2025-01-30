package com.mooncloak.kodetools.ktask

import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

/**
 * Represents an event related to the lifecycle or status of a task.
 *
 * This sealed interface is used to categorize and encapsulate different types of events that may occur during the
 * lifecycle of a task, such as when it starts running, completes, or fails. Each specific event type can carry
 * additional context or metadata relevant to that event.
 */
@ExperimentalTaskApi
@OptIn(ExperimentalUuidApi::class)
public sealed interface TaskEvent {

    /**
     * A unique identifier for the event.
     */
    public val id: String

    /**
     * The timestamp representing the time this event occurred. The exact interpretation of this timestamp depends on
     * the context in which the event is used, such as signaling when a task was created, executed, or completed.
     */
    public val timestamp: Instant

    /**
     * Represents the action associated with the task event.
     *
     * The action defines the type of operation being performed on a task and is represented by the [Action] enum. It
     * could be one of scheduling a task, removing a task, or executing a task immediately.
     */
    public val action: Action

    /**
     * A list of tasks associated with the event, representing operations or processes scheduled or performed during
     * the event's lifecycle.
     */
    public val tasks: List<Task>

    /**
     * Represents a task event indicating that a task or a set of tasks is currently running.
     *
     * @property [action] The action associated with this running event, specifying the type of operation being
     * performed.
     *
     * @property [tasks] A list of tasks that are involved in this running event. Defaults to an empty list.
     *
     * @property [id] A unique identifier for this event. Defaults to a randomly generated UUID in hex string format.
     *
     * @property [timestamp] The timestamp specifying when the event occurred. Defaults to the current system time.
     */
    public data class Running public constructor(
        public override val action: Action,
        public override val tasks: List<Task> = emptyList(),
        public override val id: String = Uuid.random().toHexString(),
        public override val timestamp: Instant = Clock.System.now(),
    ) : TaskEvent {

        public constructor(
            action: Action,
            task: Task,
            id: String = Uuid.random().toHexString(),
            timestamp: Instant = Clock.System.now()
        ) : this(
            id = id,
            timestamp = timestamp,
            action = action,
            tasks = listOf(task)
        )
    }

    /**
     * Represents a completed task event with associated metadata.
     *
     * This can be used to model and log the state of task completion within a task management or processing system.
     *
     * @param [timestamp] The time when the task(s) were completed. Defaults to the current system clock time.
     *
     * @param [action] The action associated with this event. Represents the operation performed on the task(s).
     *
     * @param [id] A unique identifier for the event. Defaults to a randomly generated UUID in hexadecimal format.
     *
     * @param [tasks] The list of tasks associated with this completion event. Defaults to an empty list.
     *
     * @param [duplicate] An optional flag indicating if this event is the result of removing a duplicate task.
     * Defaults to null.
     */
    public data class Completed public constructor(
        public override val timestamp: Instant = Clock.System.now(),
        public override val action: Action,
        public override val id: String = Uuid.random().toHexString(),
        public override val tasks: List<Task> = emptyList(),
        public val duplicate: Boolean? = null
    ) : TaskEvent {

        public constructor(
            action: Action,
            task: Task,
            id: String = Uuid.random().toHexString(),
            timestamp: Instant = Clock.System.now(),
            duplicate: Boolean? = null
        ) : this(
            id = id,
            timestamp = timestamp,
            action = action,
            tasks = listOf(task),
            duplicate = duplicate
        )
    }

    /**
     * Represents an event indicating the failure of a task or a group of tasks during processing or execution.
     *
     * @property [action] The specific action (such as scheduling, removing, or executing) associated with the failure.
     *
     * @property [tasks] A list of tasks that were involved in the failure event. Defaults to an empty list.
     *
     * @property [id] A unique identifier for this failure event. Defaults to a random unique identifier.
     *
     * @property [timestamp] The time at which the failure event was recorded. Defaults to the current system time.
     *
     * @property [cause] An optional throwable that holds additional details about the cause of the failure.
     */
    public data class Failed public constructor(
        public override val action: Action,
        public override val tasks: List<Task> = emptyList(),
        public override val id: String = Uuid.random().toHexString(),
        public override val timestamp: Instant = Clock.System.now(),
        public val cause: Throwable? = null
    ) : TaskEvent {

        public constructor(
            action: Action,
            task: Task,
            id: String = Uuid.random().toHexString(),
            timestamp: Instant = Clock.System.now(),
            cause: Throwable? = null
        ) : this(
            id = id,
            timestamp = timestamp,
            action = action,
            tasks = listOf(task),
            cause = cause
        )
    }

    /**
     * Enum representing possible actions associated with a task.
     *
     * Actions define the type of operation to be performed on a task.
     */
    @Serializable
    public enum class Action {

        /**
         * Represents the action of scheduling a task to be executed.
         *
         * This action typically involves placing a task into a queue or scheduling mechanism
         * for execution based on its associated configuration, such as its scheduled time,
         * optional delay, and potential repeat interval.
         *
         * The `SCHEDULE` action is used to initialize or prepare tasks for future execution
         * in a task management or execution system.
         */
        @SerialName(value = "schedule")
        SCHEDULE,

        /**
         * Represents the action of removing a task from a task queue or schedule.
         *
         * This action typically indicates that the task should no longer be considered
         * for execution or processing. It can be used to cancel or delete tasks that
         * are no longer needed or relevant within a task management system.
         */
        @SerialName(value = "remove")
        REMOVE,

        /**
         * Represents the action of immediately executing a task.
         *
         * The `EXECUTE` action is used to indicate the intention to perform a task operation
         * without delay or scheduling considerations, typically initiating the task's logic or
         * operation as soon as possible.
         */
        @SerialName(value = "execute")
        EXECUTE;

        public companion object {

            /**
             * Retrieves an [Action] from its name, ignoring case sensitivity.
             *
             * @param [name] The name of the action to look for.
             *
             * @return The [Action] corresponding to the specified name, or `null` if no match is found.
             */
            public operator fun get(name: String): Action? =
                Action.entries.firstOrNull { it.name.equals(name, ignoreCase = true) }
        }
    }

    public companion object
}
