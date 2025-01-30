//[ktask-core](../../../../index.md)/[com.mooncloak.kodetools.ktask](../../index.md)/[TaskEvent](../index.md)/[Completed](index.md)/[Completed](-completed.md)

# Completed

[common]\
constructor(action: [TaskEvent.Action](../-action/index.md), task: [Task](../../-task/index.md), id: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html) = Uuid.random().toHexString(), timestamp: Instant = Clock.System.now(), duplicate: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)? = null)

[common]\
constructor(timestamp: Instant = Clock.System.now(), action: [TaskEvent.Action](../-action/index.md), id: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html) = Uuid.random().toHexString(), tasks: [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;[Task](../../-task/index.md)&gt; = emptyList(), duplicate: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)? = null)

#### Parameters

common

| | |
|---|---|
| timestamp | The time when the task(s) were completed. Defaults to the current system clock time. |
| action | The action associated with this event. Represents the operation performed on the task(s). |
| id | A unique identifier for the event. Defaults to a randomly generated UUID in hexadecimal format. |
| tasks | The list of tasks associated with this completion event. Defaults to an empty list. |
| duplicate | An optional flag indicating if this event is the result of removing a duplicate task. Defaults to null. |
