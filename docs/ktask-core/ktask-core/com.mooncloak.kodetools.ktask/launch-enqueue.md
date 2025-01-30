//[ktask-core](../../index.md)/[com.mooncloak.kodetools.ktask](index.md)/[launchEnqueue](launch-enqueue.md)

# launchEnqueue

[common]\

@[ExperimentalTaskApi](-experimental-task-api/index.md)

fun [TaskService](-task-service/index.md).[launchEnqueue](launch-enqueue.md)(task: [Task](-task/index.md)): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)

Adds the specified task to the task service's queue for execution.

#### Return

`true` if the enqueue function was launched (see [ServiceLifecycle.runInScope](-service-lifecycle/run-in-scope.md)), `false` otherwise.

#### Parameters

common

| | |
|---|---|
| task | The task to be enqueued, containing its associated properties and action to be executed. |

#### See also

| |
|---|
| [ServiceLifecycle.runInScope](-service-lifecycle/run-in-scope.md) |
| [TaskQueue.enqueue](-task-queue/enqueue.md) |

[common]\

@[ExperimentalTaskApi](-experimental-task-api/index.md)

fun [TaskService](-task-service/index.md).[launchEnqueue](launch-enqueue.md)(id: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html) = Uuid.random().toHexString(), type: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)? = null, delay: [Duration](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.time/-duration/index.html)? = null, interval: [Duration](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.time/-duration/index.html)? = null, replay: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html) = 0, value: suspend () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)

Launches and enqueues a task for execution using the task service.

This method wraps the [TaskQueue.enqueue](-task-queue/enqueue.md) function, scheduling the provided task with the specified configuration parameters. The task will be executed within the service's coroutine scope if the scope is active.

#### Return

`true` if the [remove](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/index.html) function was launched (see [ServiceLifecycle.runInScope](-service-lifecycle/run-in-scope.md)), `false` otherwise.

#### Parameters

common

| | |
|---|---|
| id | The unique identifier for the task. Defaults to a randomly generated UUID. |
| type | An optional type or category for the task. |
| delay | The duration to wait before the task is executed after it is scheduled. Defaults to `null`. |
| interval | The interval between repeated executions of the task, if applicable. Defaults to `null`. |
| replay | The number of times to replay the task. Defaults to `0`. |
| value | The suspending lambda representing the logic to be executed by the task. |

#### See also

| |
|---|
| [ServiceLifecycle.runInScope](-service-lifecycle/run-in-scope.md) |
| [TaskQueue.enqueue](-task-queue/enqueue.md) |
