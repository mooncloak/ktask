//[ktask-core](../../../index.md)/[com.mooncloak.kodetools.ktask](../index.md)/[TaskQueue](index.md)/[remove](remove.md)

# remove

[common]\
abstract suspend fun [remove](remove.md)(id: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)

Removes the [Task](../-task/index.md) with the provided [id](remove.md) from the task queue.

#### Return

`true` if the [Task](../-task/index.md) with the provided [id](remove.md) exists in and was removed from the task queue, `false` otherwise.

#### Parameters

common

| | |
|---|---|
| id | The [Task.id](../-task/id.md) of the [Task](../-task/index.md) to be removed. |
