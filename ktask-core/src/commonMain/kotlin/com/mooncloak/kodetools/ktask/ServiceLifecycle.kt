package com.mooncloak.kodetools.ktask

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.cancel

/**
 * Represents the lifecycle of a service, allowing for its management in terms of starting, cancelling, and checking
 * its active state. The interface provides methods to control and interact with the service, including running blocks
 * of code within its associated coroutine scope.
 */
@ExperimentalTaskApi
public interface ServiceLifecycle : AutoCloseable {

    /**
     * Returns whether this [ServiceLifecycle] is currently active. The [ServiceLifecycle] being active depends on
     * whether the [cancel] function has been invoked, as well as, any underlying [CoroutineScope] still being active.
     * So, if the [TaskService] is started, but the associated [CoroutineScope] was cancelled, then the
     * [ServiceLifecycle] will not be active.
     */
    public val isActive: Boolean

    public override fun close() {
        cancel()
    }

    /**
     * Initiates the service lifecycle. This method starts the service, allowing it to perform its intended tasks
     * and transitions the service into an active state if possible. The behavior of the service after invoking
     * this function, as well as its interaction with the `close` or `cancel` methods, depends on the specific
     * implementation of the [ServiceLifecycle] interface.
     *
     * Note that if the underlying [CoroutineScope] is not active, then this function will have no effect and will not
     * start the service.
     *
     * @return `true` if the [ServiceLifecycle] is active, whether as a result of calling this function or if the
     * [ServiceLifecycle] was already started, otherwise `false` indicating that the [ServiceLifecycle] is not in an
     * active state.
     */
    public fun start(): Boolean

    /**
     * Cancels the service lifecycle, marking it as inactive. This may also affect any underlying resources or
     * associated coroutine scopes linked to the service. It is up to the implementation whether a [ServiceLifecycle]
     * can be restarted. Refer to the implementation's documentation.
     *
     * This method is typically used to gracefully stop any ongoing processes tied to the service and release
     * associated resources.
     */
    public fun cancel()

    /**
     * Executes a given suspend block of code within the service's coroutine scope. The block will only run if the
     * associated coroutine scope is active.
     *
     * @param [block] The suspend function to execute within the coroutine scope.
     *
     * @return `true` if the block was executed, or `false` if the coroutine scope was not active.
     */
    public fun runInScope(block: suspend CoroutineScope.() -> Unit): Boolean

    public companion object
}

/**
 * Invokes a suspending block of code while managing the [ServiceLifecycle].
 * The method ensures the [ServiceLifecycle] is started before the block is executed and cancels the [ServiceLifecycle]
 * after execution. This function is provided as a convenience for the [ServiceLifecycle] for single use scenarios, and
 * is similar to the [AutoCloseable.use] function but works with suspending functions.
 *
 * @param [block] A suspending block of code to be executed within the context of the [ServiceLifecycle].
 *
 * @return The result of executing the provided suspending block.
 */
@ExperimentalTaskApi
public suspend fun <Service : ServiceLifecycle, R> Service.useSuspending(block: suspend Service.() -> R): R {
    this.start()

    val result = block.invoke(this)

    this.cancel()

    return result
}
