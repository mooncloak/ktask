//[ktask-core](../../../../index.md)/[com.mooncloak.kodetools.ktask](../../index.md)/[TaskEvent](../index.md)/[Running](index.md)

# Running

[common]\
data class [Running](index.md)(val action: [TaskEvent.Action](../-action/index.md), val tasks: [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;[Task](../../-task/index.md)&gt; = emptyList(), val id: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html) = Uuid.random().toHexString(), val timestamp: Instant = Clock.System.now()) : [TaskEvent](../index.md)

Represents a task event indicating that a task or a set of tasks is currently running.

## Constructors

| | |
|---|---|
| [Running](-running.md) | [common]<br>constructor(action: [TaskEvent.Action](../-action/index.md), task: [Task](../../-task/index.md), id: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html) = Uuid.random().toHexString(), timestamp: Instant = Clock.System.now())constructor(action: [TaskEvent.Action](../-action/index.md), tasks: [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;[Task](../../-task/index.md)&gt; = emptyList(), id: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html) = Uuid.random().toHexString(), timestamp: Instant = Clock.System.now()) |

## Properties

| Name | Summary |
|---|---|
| [action](action.md) | [common]<br>open override val [action](action.md): [TaskEvent.Action](../-action/index.md)<br>The action associated with this running event, specifying the type of operation being performed. |
| [id](id.md) | [common]<br>open override val [id](id.md): [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)<br>A unique identifier for this event. Defaults to a randomly generated UUID in hex string format. |
| [tasks](tasks.md) | [common]<br>open override val [tasks](tasks.md): [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;[Task](../../-task/index.md)&gt;<br>A list of tasks that are involved in this running event. Defaults to an empty list. |
| [timestamp](timestamp.md) | [common]<br>open override val [timestamp](timestamp.md): Instant<br>The timestamp specifying when the event occurred. Defaults to the current system time. |
