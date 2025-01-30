//[ktask-core](../../../index.md)/[com.mooncloak.kodetools.ktask](../index.md)/[ServiceLifecycle](index.md)

# ServiceLifecycle

@[ExperimentalTaskApi](../-experimental-task-api/index.md)

interface [ServiceLifecycle](index.md) : [AutoCloseable](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-auto-closeable/index.html)

Represents the lifecycle of a service, allowing for its management in terms of starting, cancelling, and checking its active state. The interface provides methods to control and interact with the service, including running blocks of code within its associated coroutine scope.

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
| [isActive](is-active.md) | [common]<br>abstract val [isActive](is-active.md): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)<br>Returns whether this [ServiceLifecycle](index.md) is currently active. The [ServiceLifecycle](index.md) being active depends on whether the [cancel](cancel.md) function has been invoked, as well as, any underlying CoroutineScope still being active. So, if the [TaskService](../-task-service/index.md) is started, but the associated CoroutineScope was cancelled, then the [ServiceLifecycle](index.md) will not be active. |

## Functions

| Name | Summary |
|---|---|
| [cancel](cancel.md) | [common]<br>abstract fun [cancel](cancel.md)()<br>Cancels the service lifecycle, marking it as inactive. This may also affect any underlying resources or associated coroutine scopes linked to the service. It is up to the implementation whether a [ServiceLifecycle](index.md) can be restarted. Refer to the implementation's documentation. |
| [close](close.md) | [common]<br>open override fun [close](close.md)() |
| [runInScope](run-in-scope.md) | [common]<br>abstract fun [runInScope](run-in-scope.md)(block: suspend CoroutineScope.() -&gt; [Unit](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-unit/index.html)): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)<br>Executes a given suspend block of code within the service's coroutine scope. The block will only run if the associated coroutine scope is active. |
| [start](start.md) | [common]<br>abstract fun [start](start.md)(): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)<br>Initiates the service lifecycle. This method starts the service, allowing it to perform its intended tasks and transitions the service into an active state if possible. The behavior of the service after invoking this function, as well as its interaction with the `close` or `cancel` methods, depends on the specific implementation of the [ServiceLifecycle](index.md) interface. |
