//[ktask-core](../../index.md)/[com.mooncloak.kodetools.ktask](index.md)/[launchSchedule](launch-schedule.md)

# launchSchedule

[common]\

@[ExperimentalTaskApi](-experimental-task-api/index.md)

fun [TaskService](-task-service/index.md).[launchSchedule](launch-schedule.md)(scheduler: [TaskScheduler](-task-scheduler/index.md))

Launches the scheduling process using the provided [TaskScheduler](-task-scheduler/index.md).

This method applies the given scheduler to the current [TaskService](-task-service/index.md) instance to define task scheduling behavior. The scheduler's logic is invoked within a specific enqueue context.

#### Parameters

common

| | |
|---|---|
| scheduler | The [TaskScheduler](-task-scheduler/index.md) instance that defines the scheduling behavior to be applied to the [TaskService](-task-service/index.md). |
