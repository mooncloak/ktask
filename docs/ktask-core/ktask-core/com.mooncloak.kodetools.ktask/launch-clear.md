//[ktask-core](../../index.md)/[com.mooncloak.kodetools.ktask](index.md)/[launchClear](launch-clear.md)

# launchClear

[common]\

@[ExperimentalTaskApi](-experimental-task-api/index.md)

inline fun [TaskService](-task-service/index.md).[launchClear](launch-clear.md)(): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)

Launches a coroutine to clear all tasks managed by the TaskService.

This function utilizes the [ServiceLifecycle.runInScope](-service-lifecycle/run-in-scope.md) method to execute the [TaskQueue.clear](-task-queue/clear.md) operation within the coroutine scope of the [TaskService](-task-service/index.md). The `clear` function, when invoked, removes all tasks from the task queue, effectively resetting it to an empty state.

The operation will only execute if the associated coroutine scope of the TaskService is active.

#### Return

`true` if the [clear](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.text/index.html) function was launched (see [ServiceLifecycle.runInScope](-service-lifecycle/run-in-scope.md)), `false` otherwise.

#### See also

| |
|---|
| [ServiceLifecycle.runInScope](-service-lifecycle/run-in-scope.md) |
| [TaskQueue.clear](-task-queue/clear.md) |
