//[ktask-core](../../../index.md)/[com.mooncloak.kodetools.ktask](../index.md)/[TaskScheduler](index.md)

# TaskScheduler

[common]\
@[ExperimentalTaskApi](../-experimental-task-api/index.md)

fun interface [TaskScheduler](index.md)

A functional interface that represents a task scheduler designed for use with a [TaskService](../-task-service/index.md).

This interface enables the definition of scheduling behaviors by implementing the `schedule` function. Implementations can define custom logic to schedule tasks in the associated [TaskService](../-task-service/index.md).

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [common]<br>object [Companion](-companion/index.md) |

## Functions

| Name | Summary |
|---|---|
| [schedule](schedule.md) | [common]<br>abstract suspend fun [TaskService](../-task-service/index.md).[schedule](schedule.md)()<br>Defines the scheduling behavior for a [TaskService](../-task-service/index.md). |
