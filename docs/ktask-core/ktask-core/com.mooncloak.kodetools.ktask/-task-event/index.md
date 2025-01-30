//[ktask-core](../../../index.md)/[com.mooncloak.kodetools.ktask](../index.md)/[TaskEvent](index.md)

# TaskEvent

@[ExperimentalTaskApi](../-experimental-task-api/index.md)

sealed interface [TaskEvent](index.md)

Represents an event related to the lifecycle or status of a task.

This sealed interface is used to categorize and encapsulate different types of events that may occur during the lifecycle of a task, such as when it starts running, completes, or fails. Each specific event type can carry additional context or metadata relevant to that event.

#### Inheritors

| |
|---|
| [Running](-running/index.md) |
| [Completed](-completed/index.md) |
| [Failed](-failed/index.md) |

## Types

| Name | Summary |
|---|---|
| [Action](-action/index.md) | [common]<br>@Serializable<br>enum [Action](-action/index.md) : [Enum](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-enum/index.html)&lt;[TaskEvent.Action](-action/index.md)&gt; <br>Enum representing possible actions associated with a task. |
| [Companion](-companion/index.md) | [common]<br>object [Companion](-companion/index.md) |
| [Completed](-completed/index.md) | [common]<br>data class [Completed](-completed/index.md)(val timestamp: Instant = Clock.System.now(), val action: [TaskEvent.Action](-action/index.md), val id: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html) = Uuid.random().toHexString(), val tasks: [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;[Task](../-task/index.md)&gt; = emptyList(), val duplicate: [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)? = null) : [TaskEvent](index.md)<br>Represents a completed task event with associated metadata. |
| [Failed](-failed/index.md) | [common]<br>data class [Failed](-failed/index.md)(val action: [TaskEvent.Action](-action/index.md), val tasks: [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;[Task](../-task/index.md)&gt; = emptyList(), val id: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html) = Uuid.random().toHexString(), val timestamp: Instant = Clock.System.now(), val cause: [Throwable](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-throwable/index.html)? = null) : [TaskEvent](index.md)<br>Represents an event indicating the failure of a task or a group of tasks during processing or execution. |
| [Running](-running/index.md) | [common]<br>data class [Running](-running/index.md)(val action: [TaskEvent.Action](-action/index.md), val tasks: [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;[Task](../-task/index.md)&gt; = emptyList(), val id: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html) = Uuid.random().toHexString(), val timestamp: Instant = Clock.System.now()) : [TaskEvent](index.md)<br>Represents a task event indicating that a task or a set of tasks is currently running. |

## Properties

| Name | Summary |
|---|---|
| [action](action.md) | [common]<br>abstract val [action](action.md): [TaskEvent.Action](-action/index.md)<br>Represents the action associated with the task event. |
| [id](id.md) | [common]<br>abstract val [id](id.md): [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)<br>A unique identifier for the event. |
| [tasks](tasks.md) | [common]<br>abstract val [tasks](tasks.md): [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;[Task](../-task/index.md)&gt;<br>A list of tasks associated with the event, representing operations or processes scheduled or performed during the event's lifecycle. |
| [timestamp](timestamp.md) | [common]<br>abstract val [timestamp](timestamp.md): Instant<br>The timestamp representing the time this event occurred. The exact interpretation of this timestamp depends on the context in which the event is used, such as signaling when a task was created, executed, or completed. |
