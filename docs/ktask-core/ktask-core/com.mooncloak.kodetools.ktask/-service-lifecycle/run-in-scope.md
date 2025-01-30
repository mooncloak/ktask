//[ktask-core](../../../index.md)/[com.mooncloak.kodetools.ktask](../index.md)/[ServiceLifecycle](index.md)/[runInScope](run-in-scope.md)

# runInScope

[common]\
abstract fun [runInScope](run-in-scope.md)(block: suspend CoroutineScope.() -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)

Executes a given suspend block of code within the service's coroutine scope. The block will only run if the associated coroutine scope is active.

#### Return

`true` if the block was executed, or `false` if the coroutine scope was not active.

#### Parameters

common

| | |
|---|---|
| block | The suspend function to execute within the coroutine scope. |
