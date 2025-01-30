//[ktask-core](../../index.md)/[com.mooncloak.kodetools.ktask](index.md)/[launchRemove](launch-remove.md)

# launchRemove

[common]\

@[ExperimentalTaskApi](-experimental-task-api/index.md)

inline fun [TaskService](-task-service/index.md).[launchRemove](launch-remove.md)(id: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)

Launches the removal of a task with the specified identifier within the [TaskService](-task-service/index.md) scope.

This function ensures the removal operation is executed within the coroutine scope of [TaskService](-task-service/index.md) by delegating to the [TaskQueue.remove](-task-queue/remove.md) function. The task identified by the given `id` will be removed if it exists.

#### Return

`true` if the [remove](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/index.html) function was launched (see [ServiceLifecycle.runInScope](-service-lifecycle/run-in-scope.md)), `false` otherwise.

#### Parameters

common

| | |
|---|---|
| id | The unique identifier of the task to be removed from the task queue. |

#### See also

| |
|---|
| [ServiceLifecycle.runInScope](-service-lifecycle/run-in-scope.md) |
| [TaskQueue.remove](-task-queue/remove.md) |
