//[ktask-core](../../../index.md)/[com.mooncloak.kodetools.ktask](../index.md)/[TaskQueue](index.md)/[enqueue](enqueue.md)

# enqueue

[common]\
abstract suspend fun [enqueue](enqueue.md)(task: [Task](../-task/index.md)): [Task](../-task/index.md)

Adds the specified [task](enqueue.md) to the task queue for scheduled execution.

#### Return

The enqueued [Task](../-task/index.md). Note that the returned [Task](../-task/index.md) might be different from the provided [task](enqueue.md) value because the [Task.scheduled](../-task/scheduled.md) property would be overwritten.

#### Parameters

common

| | |
|---|---|
| task | The [Task](../-task/index.md) to be added to the queue. |

[common]\
abstract suspend fun [enqueue](enqueue.md)(id: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html) = Uuid.random().toHexString(), type: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)? = null, delay: [Duration](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.time/-duration/index.html)? = null, interval: [Duration](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.time/-duration/index.html)? = null, replay: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html) = 0, value: suspend () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)): [Task](../-task/index.md)

Creates a [Task](../-task/index.md) from the provided values and adds it to the queue to be invoked.

#### Return

The newly created and enqueued [Task](../-task/index.md).

#### Parameters

common

| | |
|---|---|
| id | The unique identifier of the [Task](../-task/index.md). If a [Task](../-task/index.md) exists in the queue with the same identifier value, that [Task](../-task/index.md) will be removed, and not invoked, before this one is added. |
| type | The type of this [Task](../-task/index.md). If a [Task](../-task/index.md) exists in the queue with the same type value, that [Task](../-task/index.md) will be removed, and not invoked, before this one is added. |
| delay | The [Duration](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.time/-duration/index.html) to wait from the moment this [Task](../-task/index.md) was scheduled for it to be invoked. If this value is `null`, then the [Task](../-task/index.md) will be invoked whenever it is retrieved from the queue without a timeout delay. |
| interval | The [Duration](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.time/-duration/index.html) between subsequent invocations of this [Task](../-task/index.md). If this [Task](../-task/index.md) is to be invoked more than once, this value determines the [Duration](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.time/-duration/index.html) in between each running of this task. If this value is `null`, then the [Task](../-task/index.md) will only be invoked at most once. This value is used in unison with the [replay](enqueue.md) value. Defaults to `null`. |
| replay | The amount of times this [Task](../-task/index.md) should be invoked. If this value is less than zero and [interval](enqueue.md) was set, the task should be invoked indefinitely. If this value is zero, the task will only be invoked the first time and will ot be replayed. Otherwise, the value will be replayed this amount of times. Defaults to zero. |
| value | The function that performs the [Task](../-task/index.md) logic that will be invoked when it is retrieved from the queue by the [TaskService](../-task-service/index.md). |
