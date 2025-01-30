//[ktask-core](../../../index.md)/[com.mooncloak.kodetools.ktask](../index.md)/[DefaultTask](index.md)

# DefaultTask

[common]\
@[ExperimentalTaskApi](../-experimental-task-api/index.md)

abstract class [DefaultTask](index.md)(val id: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html) = Uuid.random().toHexString(), val type: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)? = null, val delay: [Duration](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.time/-duration/index.html)? = null, val interval: [Duration](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.time/-duration/index.html)? = null, val replay: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html) = 0, val scheduled: Instant = Clock.System.now()) : [Task](../-task/index.md)

An abstract implementation of the [Task](../-task/index.md) interface that provides default behavior and property initializations for creating tasks. This class can be extended to define specific executable tasks.

## Constructors

| | |
|---|---|
| [DefaultTask](-default-task.md) | [common]<br>constructor(id: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html) = Uuid.random().toHexString(), type: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)? = null, delay: [Duration](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.time/-duration/index.html)? = null, interval: [Duration](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.time/-duration/index.html)? = null, replay: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html) = 0, scheduled: Instant = Clock.System.now()) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [common]<br>object [Companion](-companion/index.md) |

## Properties

| Name | Summary |
|---|---|
| [delay](delay.md) | [common]<br>open override val [delay](delay.md): [Duration](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.time/-duration/index.html)? = null<br>An optional delay before the task becomes executable after its scheduled time. |
| [estimatedRuntime](../estimated-runtime.md) | [common]<br>@[ExperimentalTaskApi](../-experimental-task-api/index.md)<br>val [Task](../-task/index.md).[estimatedRuntime](../estimated-runtime.md): Instant<br>Represents the calculated runtime for the task, which is the point in time when the task is expected to be ready for execution. If a delay is specified, it is added to the scheduled time; otherwise, the scheduled time is used. |
| [id](id.md) | [common]<br>open override val [id](id.md): [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)<br>A unique identifier for the task. |
| [interval](interval.md) | [common]<br>open override val [interval](interval.md): [Duration](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.time/-duration/index.html)? = null<br>An optional interval defining the time between repeated task executions. |
| [replay](replay.md) | [common]<br>open override val [replay](replay.md): [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html) = 0<br>Defines how many additional times the task should be executed. A negative value indicates unlimited retries, while 0 prevents further executions. |
| [scheduled](scheduled.md) | [common]<br>override val [scheduled](scheduled.md): Instant<br>The Instant the task was scheduled for execution by placing it in the task service's queue. Note that this is not the time when the task will run. If you want an estimate of when the task will run, use the [estimatedRuntime](../estimated-runtime.md) property. |
| [type](type.md) | [common]<br>open override val [type](type.md): [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)? = null<br>An optional type or category for the task, allowing classification. |

## Functions

| Name | Summary |
|---|---|
| [copy](copy.md) | [common]<br>override fun [copy](copy.md)(id: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), type: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)?, scheduled: Instant, delay: [Duration](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.time/-duration/index.html)?, interval: [Duration](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.time/-duration/index.html)?, replay: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html)): [Task](../-task/index.md)<br>Creates a copy of this task with optional overrides for its properties. |
| [invoke](invoke.md) | [common]<br>abstract suspend operator override fun [invoke](invoke.md)()<br>Executes the task's associated action. The implementation of this function defines the specific behavior required to perform the task's operation. |
| [isRunnableAt](../is-runnable-at.md) | [common]<br>@[ExperimentalTaskApi](../-experimental-task-api/index.md)<br>fun [Task](../-task/index.md).[isRunnableAt](../is-runnable-at.md)(instant: Instant): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)<br>Determines if the task is runnable at a specific point in time, considering its scheduled time and optional delay. |
| [shouldRunAgain](../should-run-again.md) | [common]<br>@[ExperimentalTaskApi](../-experimental-task-api/index.md)<br>fun [Task](../-task/index.md).[shouldRunAgain](../should-run-again.md)(): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)<br>Determines if the task should run again based on its [Task.replay](../-task/replay.md) value. |
