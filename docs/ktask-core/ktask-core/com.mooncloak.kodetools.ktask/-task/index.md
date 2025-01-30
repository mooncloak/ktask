//[ktask-core](../../../index.md)/[com.mooncloak.kodetools.ktask](../index.md)/[Task](index.md)

# Task

@[ExperimentalTaskApi](../-experimental-task-api/index.md)

interface [Task](index.md)

Represents a task with an associated action to be executed, which may include scheduling details and execution constraints.

#### Inheritors

| |
|---|
| [DefaultTask](../-default-task/index.md) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [common]<br>object [Companion](-companion/index.md) |

## Properties

| Name | Summary |
|---|---|
| [delay](delay.md) | [common]<br>abstract val [delay](delay.md): [Duration](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.time/-duration/index.html)?<br>An optional delay before the task becomes executable after its scheduled time. |
| [estimatedRuntime](../estimated-runtime.md) | [common]<br>@[ExperimentalTaskApi](../-experimental-task-api/index.md)<br>val [Task](index.md).[estimatedRuntime](../estimated-runtime.md): Instant<br>Represents the calculated runtime for the task, which is the point in time when the task is expected to be ready for execution. If a delay is specified, it is added to the scheduled time; otherwise, the scheduled time is used. |
| [id](id.md) | [common]<br>abstract val [id](id.md): [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)<br>A unique identifier for the task. |
| [interval](interval.md) | [common]<br>abstract val [interval](interval.md): [Duration](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.time/-duration/index.html)?<br>An optional interval defining the time between repeated task executions. |
| [replay](replay.md) | [common]<br>abstract val [replay](replay.md): [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html)<br>Defines how many additional times the task should be executed. A negative value indicates unlimited retries, while 0 prevents further executions. |
| [scheduled](scheduled.md) | [common]<br>abstract val [scheduled](scheduled.md): Instant<br>The Instant the task was scheduled for execution by placing it in the task service's queue. Note that this is not the time when the task will run. If you want an estimate of when the task will run, use the [estimatedRuntime](../estimated-runtime.md) property. |
| [type](type.md) | [common]<br>abstract val [type](type.md): [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)?<br>An optional type or category for the task, allowing classification. |

## Functions

| Name | Summary |
|---|---|
| [copy](copy.md) | [common]<br>abstract fun [copy](copy.md)(id: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html) = this.id, type: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)? = this.type, scheduled: Instant = this.scheduled, delay: [Duration](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.time/-duration/index.html)? = this.delay, interval: [Duration](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.time/-duration/index.html)? = this.interval, replay: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html) = this.replay): [Task](index.md)<br>Creates a copy of this task with optional overrides for its properties. |
| [invoke](invoke.md) | [common]<br>abstract suspend operator fun [invoke](invoke.md)()<br>Executes the task's associated action. The implementation of this function defines the specific behavior required to perform the task's operation. |
| [isRunnableAt](../is-runnable-at.md) | [common]<br>@[ExperimentalTaskApi](../-experimental-task-api/index.md)<br>fun [Task](index.md).[isRunnableAt](../is-runnable-at.md)(instant: Instant): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)<br>Determines if the task is runnable at a specific point in time, considering its scheduled time and optional delay. |
| [shouldRunAgain](../should-run-again.md) | [common]<br>@[ExperimentalTaskApi](../-experimental-task-api/index.md)<br>fun [Task](index.md).[shouldRunAgain](../should-run-again.md)(): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)<br>Determines if the task should run again based on its [Task.replay](replay.md) value. |
