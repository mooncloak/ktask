//[ktask-core](../../../index.md)/[com.mooncloak.kodetools.ktask](../index.md)/[TaskQueue](index.md)

# TaskQueue

@[ExperimentalTaskApi](../-experimental-task-api/index.md)

interface [TaskQueue](index.md)

Represents a task queue, enabling tasks to be added, retrieved, and managed. Tasks in the queue can be identified through unique identifiers. The queue supports operations such as enqueuing, removing a task, clearing the queue, and retrieving tasks.

#### Inheritors

| |
|---|
| [TaskService](../-task-service/index.md) |

## Types

| Name | Summary |
|---|---|
| [Companion](-companion/index.md) | [common]<br>object [Companion](-companion/index.md) |

## Properties

| Name | Summary |
|---|---|
| [size](size.md) | [common]<br>abstract val [size](size.md): [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html)<br>The current number of tasks in the queue. |

## Functions

| Name | Summary |
|---|---|
| [clear](clear.md) | [common]<br>abstract suspend fun [clear](clear.md)()<br>Clears all tasks from the task queue. |
| [contains](contains.md) | [common]<br>abstract operator fun [contains](contains.md)(id: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)<br>Determines whether the task queue contains a task with the specified unique identifier. |
| [enqueue](enqueue.md) | [common]<br>abstract suspend fun [enqueue](enqueue.md)(task: [Task](../-task/index.md)): [Task](../-task/index.md)<br>Adds the specified [task](enqueue.md) to the task queue for scheduled execution.<br>[common]<br>abstract suspend fun [enqueue](enqueue.md)(id: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html) = Uuid.random().toHexString(), type: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)? = null, delay: [Duration](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.time/-duration/index.html)? = null, interval: [Duration](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.time/-duration/index.html)? = null, replay: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html) = 0, value: suspend () -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)): [Task](../-task/index.md)<br>Creates a [Task](../-task/index.md) from the provided values and adds it to the queue to be invoked. |
| [get](get.md) | [common]<br>abstract operator fun [get](get.md)(id: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)): [Task](../-task/index.md)<br>Retrieves a [Task](../-task/index.md) from the task queue with the specified unique identifier. |
| [getAll](get-all.md) | [common]<br>abstract fun [getAll](get-all.md)(): [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;[Task](../-task/index.md)&gt;<br>Retrieves all tasks currently present in the task queue. |
| [getOrNull](../get-or-null.md) | [common]<br>@[ExperimentalTaskApi](../-experimental-task-api/index.md)<br>fun [TaskQueue](index.md).[getOrNull](../get-or-null.md)(id: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)): [Task](../-task/index.md)?<br>Safely retrieves a [Task](../-task/index.md) from the task queue by its unique identifier. If no task with the specified identifier exists, this method returns `null` instead of throwing an exception. |
| [isEmpty](is-empty.md) | [common]<br>open fun [isEmpty](is-empty.md)(): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)<br>Checks if the task queue is empty. |
| [remove](remove.md) | [common]<br>abstract suspend fun [remove](remove.md)(id: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)<br>Removes the [Task](../-task/index.md) with the provided [id](remove.md) from the task queue. |
