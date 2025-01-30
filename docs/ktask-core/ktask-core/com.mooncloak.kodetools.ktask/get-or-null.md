//[ktask-core](../../index.md)/[com.mooncloak.kodetools.ktask](index.md)/[getOrNull](get-or-null.md)

# getOrNull

[common]\

@[ExperimentalTaskApi](-experimental-task-api/index.md)

fun [TaskQueue](-task-queue/index.md).[getOrNull](get-or-null.md)(id: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)): [Task](-task/index.md)?

Safely retrieves a [Task](-task/index.md) from the task queue by its unique identifier. If no task with the specified identifier exists, this method returns `null` instead of throwing an exception.

#### Return

The [Task](-task/index.md) associated with the given identifier, or `null` if no such task exists.

#### Parameters

common

| | |
|---|---|
| id | The unique identifier of the [Task](-task/index.md) to retrieve. |
