//[ktask-core](../../index.md)/[com.mooncloak.kodetools.ktask](index.md)/[isRunnableAt](is-runnable-at.md)

# isRunnableAt

[common]\

@[ExperimentalTaskApi](-experimental-task-api/index.md)

fun [Task](-task/index.md).[isRunnableAt](is-runnable-at.md)(instant: Instant): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)

Determines if the task is runnable at a specific point in time, considering its scheduled time and optional delay.

#### Return

`true` if the task is runnable at the given time, otherwise `false`.

#### Parameters

common

| | |
|---|---|
| instant | The point in time to evaluate if the task can be executed. |
