//[ktask-core](../../../../index.md)/[com.mooncloak.kodetools.ktask](../../index.md)/[TaskEvent](../index.md)/[Failed](index.md)

# Failed

[common]\
data class [Failed](index.md)(val action: [TaskEvent.Action](../-action/index.md), val tasks: [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;[Task](../../-task/index.md)&gt; = emptyList(), val id: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html) = Uuid.random().toHexString(), val timestamp: Instant = Clock.System.now(), val cause: [Throwable](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-throwable/index.html)? = null) : [TaskEvent](../index.md)

Represents an event indicating the failure of a task or a group of tasks during processing or execution.

## Constructors

| | |
|---|---|
| [Failed](-failed.md) | [common]<br>constructor(action: [TaskEvent.Action](../-action/index.md), task: [Task](../../-task/index.md), id: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html) = Uuid.random().toHexString(), timestamp: Instant = Clock.System.now(), cause: [Throwable](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-throwable/index.html)? = null)constructor(action: [TaskEvent.Action](../-action/index.md), tasks: [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;[Task](../../-task/index.md)&gt; = emptyList(), id: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html) = Uuid.random().toHexString(), timestamp: Instant = Clock.System.now(), cause: [Throwable](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-throwable/index.html)? = null) |

## Properties

| Name | Summary |
|---|---|
| [action](action.md) | [common]<br>open override val [action](action.md): [TaskEvent.Action](../-action/index.md)<br>The specific action (such as scheduling, removing, or executing) associated with the failure. |
| [cause](cause.md) | [common]<br>val [cause](cause.md): [Throwable](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-throwable/index.html)? = null<br>An optional throwable that holds additional details about the cause of the failure. |
| [id](id.md) | [common]<br>open override val [id](id.md): [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)<br>A unique identifier for this failure event. Defaults to a random unique identifier. |
| [tasks](tasks.md) | [common]<br>open override val [tasks](tasks.md): [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;[Task](../../-task/index.md)&gt;<br>A list of tasks that were involved in the failure event. Defaults to an empty list. |
| [timestamp](timestamp.md) | [common]<br>open override val [timestamp](timestamp.md): Instant<br>The time at which the failure event was recorded. Defaults to the current system time. |
