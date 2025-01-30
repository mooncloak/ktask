//[ktask-core](../../../../index.md)/[com.mooncloak.kodetools.ktask](../../index.md)/[TaskEvent](../index.md)/[Running](index.md)/[Running](-running.md)

# Running

[common]\
constructor(action: [TaskEvent.Action](../-action/index.md), task: [Task](../../-task/index.md), id: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html) = Uuid.random().toHexString(), timestamp: Instant = Clock.System.now())

constructor(action: [TaskEvent.Action](../-action/index.md), tasks: [List](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.collections/-list/index.html)&lt;[Task](../../-task/index.md)&gt; = emptyList(), id: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html) = Uuid.random().toHexString(), timestamp: Instant = Clock.System.now())
