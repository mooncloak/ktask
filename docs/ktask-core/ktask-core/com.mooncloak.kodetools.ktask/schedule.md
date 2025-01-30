//[ktask-core](../../index.md)/[com.mooncloak.kodetools.ktask](index.md)/[schedule](schedule.md)

# schedule

[common]\

@[ExperimentalTaskApi](-experimental-task-api/index.md)

suspend fun [TaskService](-task-service/index.md).[schedule](schedule.md)(scheduler: [TaskScheduler](-task-scheduler/index.md))

Invokes the scheduling behavior provided by the given [TaskScheduler](-task-scheduler/index.md) within the context of the current [TaskService](-task-service/index.md) instance.

#### Parameters

common

| | |
|---|---|
| scheduler | The [TaskScheduler](-task-scheduler/index.md) defining the scheduling logic to be applied on the [TaskService](-task-service/index.md). |
