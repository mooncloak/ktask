//[ktask-core](../../../index.md)/[com.mooncloak.kodetools.ktask](../index.md)/[TaskQueue](index.md)/[getAll](get-all.md)

# getAll

[common]\
abstract fun [getAll](get-all.md)(): [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;[Task](../-task/index.md)&gt;

Retrieves all tasks currently present in the task queue.

!Note The order of the [Task](../-task/index.md)s in the returned [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html) does NOT indicate the execution order of the [Task](../-task/index.md)s.

#### Return

A list of all tasks in the queue. If the queue is empty, an empty list is returned.
