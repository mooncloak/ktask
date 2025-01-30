//[ktask-core](../../../index.md)/[com.mooncloak.kodetools.ktask](../index.md)/[TaskScheduler](index.md)/[schedule](schedule.md)

# schedule

[common]\
abstract suspend fun [TaskService](../-task-service/index.md).[schedule](schedule.md)()

Defines the scheduling behavior for a [TaskService](../-task-service/index.md).

This method should be implemented to specify how tasks are scheduled within the context of a [TaskService](../-task-service/index.md) instance. It allows custom scheduling logic to be applied to the associated service, enabling dynamic task management.

#### Receiver

A [TaskService](../-task-service/index.md) instance that provides the context and task-related operations.
