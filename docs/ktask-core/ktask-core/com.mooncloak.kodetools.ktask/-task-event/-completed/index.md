//[ktask-core](../../../../index.md)/[com.mooncloak.kodetools.ktask](../../index.md)/[TaskEvent](../index.md)/[Completed](index.md)

# Completed

data class [Completed](index.md)(val timestamp: Instant = Clock.System.now(), val action: [TaskEvent.Action](../-action/index.md), val id: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html) = Uuid.random().toHexString(), val tasks: [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;[Task](../../-task/index.md)&gt; = emptyList(), val duplicate: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)? = null) : [TaskEvent](../index.md)

Represents a completed task event with associated metadata.

This can be used to model and log the state of task completion within a task management or processing system.

#### Parameters

common

| | |
|---|---|
| timestamp | The time when the task(s) were completed. Defaults to the current system clock time. |
| action | The action associated with this event. Represents the operation performed on the task(s). |
| id | A unique identifier for the event. Defaults to a randomly generated UUID in hexadecimal format. |
| tasks | The list of tasks associated with this completion event. Defaults to an empty list. |
| duplicate | An optional flag indicating if this event is the result of removing a duplicate task. Defaults to null. |

## Constructors

| | |
|---|---|
| [Completed](-completed.md) | [common]<br>constructor(action: [TaskEvent.Action](../-action/index.md), task: [Task](../../-task/index.md), id: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html) = Uuid.random().toHexString(), timestamp: Instant = Clock.System.now(), duplicate: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)? = null)constructor(timestamp: Instant = Clock.System.now(), action: [TaskEvent.Action](../-action/index.md), id: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html) = Uuid.random().toHexString(), tasks: [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;[Task](../../-task/index.md)&gt; = emptyList(), duplicate: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)? = null) |

## Properties

| Name | Summary |
|---|---|
| [action](action.md) | [common]<br>open override val [action](action.md): [TaskEvent.Action](../-action/index.md) |
| [duplicate](duplicate.md) | [common]<br>val [duplicate](duplicate.md): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)? = null |
| [id](id.md) | [common]<br>open override val [id](id.md): [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html) |
| [tasks](tasks.md) | [common]<br>open override val [tasks](tasks.md): [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;[Task](../../-task/index.md)&gt; |
| [timestamp](timestamp.md) | [common]<br>open override val [timestamp](timestamp.md): Instant |
