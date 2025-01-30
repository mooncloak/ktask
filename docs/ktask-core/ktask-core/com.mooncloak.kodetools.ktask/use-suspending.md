//[ktask-core](../../index.md)/[com.mooncloak.kodetools.ktask](index.md)/[useSuspending](use-suspending.md)

# useSuspending

[common]\

@[ExperimentalTaskApi](-experimental-task-api/index.md)

suspend fun &lt;[Service](use-suspending.md) : [ServiceLifecycle](-service-lifecycle/index.md), [R](use-suspending.md)&gt; [Service](use-suspending.md).[useSuspending](use-suspending.md)(block: suspend [Service](use-suspending.md).() -&gt; [R](use-suspending.md)): [R](use-suspending.md)

Invokes a suspending block of code while managing the [ServiceLifecycle](-service-lifecycle/index.md). The method ensures the [ServiceLifecycle](-service-lifecycle/index.md) is started before the block is executed and cancels the [ServiceLifecycle](-service-lifecycle/index.md) after execution. This function is provided as a convenience for the [ServiceLifecycle](-service-lifecycle/index.md) for single use scenarios, and is similar to the [AutoCloseable.use](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/index.html) function but works with suspending functions.

#### Return

The result of executing the provided suspending block.

#### Parameters

common

| | |
|---|---|
| block | A suspending block of code to be executed within the context of the [ServiceLifecycle](-service-lifecycle/index.md). |
