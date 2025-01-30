//[ktask-core](../../../index.md)/[com.mooncloak.kodetools.ktask](../index.md)/[ServiceLifecycle](index.md)/[isActive](is-active.md)

# isActive

[common]\
abstract val [isActive](is-active.md): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)

Returns whether this [ServiceLifecycle](index.md) is currently active. The [ServiceLifecycle](index.md) being active depends on whether the [cancel](cancel.md) function has been invoked, as well as, any underlying CoroutineScope still being active. So, if the [TaskService](../-task-service/index.md) is started, but the associated CoroutineScope was cancelled, then the [ServiceLifecycle](index.md) will not be active.
