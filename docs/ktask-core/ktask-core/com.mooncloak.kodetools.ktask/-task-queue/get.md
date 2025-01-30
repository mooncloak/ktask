//[ktask-core](../../../index.md)/[com.mooncloak.kodetools.ktask](../index.md)/[TaskQueue](index.md)/[get](get.md)

# get

[common]\
abstract operator fun [get](get.md)(id: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)): [Task](../-task/index.md)

Retrieves a [Task](../-task/index.md) from the task queue with the specified unique identifier.

#### Return

The [Task](../-task/index.md) associated with the given identifier.

#### Parameters

common

| | |
|---|---|
| id | The unique identifier of the [Task](../-task/index.md) to retrieve. |

#### Throws

| | |
|---|---|
| [NoSuchElementException](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-no-such-element-exception/index.html) | If no [Task](../-task/index.md) with the specified identifier is found in the task queue. |
| [CancellationException](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.coroutines.cancellation/-cancellation-exception/index.html) | If the operation is canceled. |
