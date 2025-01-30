//[ktask-core](../../index.md)/[com.mooncloak.kodetools.ktask](index.md)/[estimatedRuntime](estimated-runtime.md)

# estimatedRuntime

[common]\

@[ExperimentalTaskApi](-experimental-task-api/index.md)

val [Task](-task/index.md).[estimatedRuntime](estimated-runtime.md): Instant

Represents the calculated runtime for the task, which is the point in time when the task is expected to be ready for execution. If a delay is specified, it is added to the scheduled time; otherwise, the scheduled time is used.

!Note This is an estimate and NOT an exact time. It is up to the [TaskService](-task-service/index.md) implementation to determine when to run [Task](-task/index.md)s and in what order.

#### Return

The determined execution time for the task as an Instant.
