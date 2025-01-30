package com.mooncloak.kodetools.ktask

import kotlinx.datetime.Instant
import kotlin.time.Duration

/**
 * Represents a task with an associated action to be executed, which may include scheduling
 * details and execution constraints.
 */
@ExperimentalTaskApi
public interface Task {

    /**
     * A unique identifier for the task.
     */
    public val id: String

    /**
     * An optional type or category for the task, allowing classification.
     */
    public val type: String?

    /**
     * The [Instant] the task was scheduled for execution by placing it in the task service's queue. Note that this is
     * not the time when the task will run. If you want an estimate of when the task will run, use the
     * [estimatedRuntime] property.
     */
    public val scheduled: Instant

    /**
     * An optional delay before the task becomes executable after its scheduled time.
     */
    public val delay: Duration?

    /**
     * An optional interval defining the time between repeated task executions.
     */
    public val interval: Duration?

    /**
     * Defines how many additional times the task should be executed. A negative value indicates unlimited retries,
     * while 0 prevents further executions.
     */
    public val replay: Int

    /**
     * Executes the task's associated action. The implementation of this function
     * defines the specific behavior required to perform the task's operation.
     *
     * This function is expected to handle the invocation asynchronously.
     */
    public suspend operator fun invoke()

    /**
     * Creates a copy of this task with optional overrides for its properties.
     *
     * @param [id] the unique identifier for the task. Defaults to the value from the existing task. Note that
     * [Task.id] values MUST be unique, so adding a [Task] to a [TaskService] with the same identifier value will
     * typically override the previous value. Though, it is up to the implementation of [TaskService] to define that
     * behavior.
     *
     * @param [type] an optional type or category for the task. Defaults to the value from the existing task.
     *
     * @param [scheduled] the scheduled time for the task. Defaults to the value from the existing task.
     *
     * @param [delay] an optional delay before the task becomes executable. Defaults to the value from the existing
     * task.
     *
     * @param [interval] an optional interval defining the time between repeated executions. Defaults to the value from
     * the existing task.
     *
     * @param [replay] the number of additional executions allowed. Defaults to the value from the existing task.
     * @return a new instance of the task with the specified parameters.
     */
    public fun copy(
        id: String = this.id,
        type: String? = this.type,
        scheduled: Instant = this.scheduled,
        delay: Duration? = this.delay,
        interval: Duration? = this.interval,
        replay: Int = this.replay
    ): Task

    public companion object
}

/**
 * Represents the calculated runtime for the task, which is the point in time when the task
 * is expected to be ready for execution. If a delay is specified, it is added to the
 * scheduled time; otherwise, the scheduled time is used.
 *
 * > [!Note]
 * > This is an estimate and NOT an exact time. It is up to the [TaskService] implementation to determine when to run
 * > [Task]s and in what order.
 *
 * @return The determined execution time for the task as an [Instant].
 */
@ExperimentalTaskApi
public val Task.estimatedRuntime: Instant
    get() = delay?.let { scheduled + it } ?: scheduled

/**
 * Determines if the task should run again based on its [Task.replay] value.
 *
 * If the [Task.replay] value is less than zero, then it should be rerun indefinitely, Otherwise, the [Task.replay]
 * indicates how many more times the [Task] should be run.
 *
 * @return `true` if the task's replay property is not equal to 0, otherwise `false`.
 */
@ExperimentalTaskApi
public fun Task.shouldRunAgain(): Boolean =
    this.replay != 0

/**
 * Determines if the task is runnable at a specific point in time, considering its scheduled time and optional delay.
 *
 * @param [instant] The point in time to evaluate if the task can be executed.
 *
 * @return `true` if the task is runnable at the given time, otherwise `false`.
 */
@ExperimentalTaskApi
public fun Task.isRunnableAt(instant: Instant): Boolean =
    (instant > scheduled + (delay ?: Duration.ZERO))
