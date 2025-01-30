//[ktask-core](../../../index.md)/[com.mooncloak.kodetools.ktask](../index.md)/[ServiceLifecycle](index.md)/[cancel](cancel.md)

# cancel

[common]\
abstract fun [cancel](cancel.md)()

Cancels the service lifecycle, marking it as inactive. This may also affect any underlying resources or associated coroutine scopes linked to the service. It is up to the implementation whether a [ServiceLifecycle](index.md) can be restarted. Refer to the implementation's documentation.

This method is typically used to gracefully stop any ongoing processes tied to the service and release associated resources.
