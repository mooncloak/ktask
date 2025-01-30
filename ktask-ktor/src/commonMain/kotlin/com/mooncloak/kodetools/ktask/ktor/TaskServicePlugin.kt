package com.mooncloak.kodetools.ktask.ktor

import com.mooncloak.kodetools.ktask.ExperimentalTaskApi
import com.mooncloak.kodetools.ktask.TaskService
import com.mooncloak.kodetools.ktask.launchEnqueue
import io.ktor.server.application.*
import io.ktor.server.application.hooks.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.datetime.Clock
import kotlin.jvm.JvmInline
import kotlin.time.Duration
import kotlin.time.Duration.Companion.seconds

@ExperimentalTaskApi
internal sealed interface ProvidedTaskService {

    @JvmInline
    value class Service internal constructor(val taskService: TaskService) : ProvidedTaskService

    data class Values internal constructor(
        val coroutineScope: CoroutineScope?,
        val clock: Clock,
        val downtimeDuration: Duration
    ) : ProvidedTaskService
}

/**
 * Configuration class for defining and providing a TaskService to the TaskService Plugin.
 *
 * This class allows customization of the TaskService by providing different configurations.
 * It supports two approaches to set up the service:
 * - Providing an existing [TaskService] implementation.
 * - Defining specific attributes for the service, such as coroutine scope, clock, and downtime duration.
 *
 * The configured [TaskService] can manage the scheduling, execution, and lifecycle of tasks according to the provided
 * parameters.
 */
@ExperimentalTaskApi
public class TaskServicePluginConfig {

    internal var service: ProvidedTaskService? = null

    /**
     * Configures the [TaskService] for the TaskService Plugin.
     *
     * This function allows providing an existing implementation of [TaskService] to configure the service. The
     * provided [TaskService] will be encapsulated within a `ProvidedTaskService.Service` instance.
     *
     * @param [taskService] the implementation of [TaskService] to be used for managing task scheduling, execution,
     * and lifecycle.
     */
    public fun service(taskService: TaskService) {
        this.service = ProvidedTaskService.Service(taskService)
    }

    /**
     * Configures the TaskService with the specified parameters.
     *
     * This method allows customization of the TaskService by defining specific attributes, such as a coroutine scope,
     * a clock for time management, and the downtime duration.
     *
     * @param [coroutineScope] the coroutine scope to manage the lifecycle of tasks. If `null`, a [CoroutineScope] will
     * be created that associated with the [Application.coroutineContext]. Defaults to `null`.
     *
     * @param [clock] the clock used for time management within the TaskService. Defaults to the system clock.
     *
     * @param [downtimeDuration] the duration of downtime for the TaskService. When there are no more tasks to execute,
     * the [TaskService] will delay for this period of time before checking if more tasks were added. This allows the
     * [TaskService] to not exhaust system resources. Defaults to 15 seconds.
     */
    public fun service(
        coroutineScope: CoroutineScope? = null,
        clock: Clock = Clock.System,
        downtimeDuration: Duration = 15.seconds
    ) {
        this.service = ProvidedTaskService.Values(
            coroutineScope = coroutineScope,
            clock = clock,
            downtimeDuration = downtimeDuration
        )
    }
}

/**
 * Application plugin that provides task management functionalities through a customizable [TaskService].
 *
 * The `TaskService` plugin is responsible for managing scheduled and ad-hoc tasks within an application. It
 * initializes an instance of the [TaskService] (either provided externally or created internally) and ensures the
 * lifecycle of the service aligns with the application's lifecycle.
 *
 * Configuration of the plugin allows users to supply a pre-existing task service or configure one with custom
 * parameters such as coroutine scope, clock instance, and downtime duration.
 *
 * Initialization Behavior:
 * - If a task service is provided, it uses the provided service instance.
 * - If no service is provided, it creates an instance of `KtorTaskService` with default parameters or the ones
 * specified in the plugin configuration.
 *
 * During the application lifecycle:
 * - The task service starts when the application starts.
 * - The task service cancels and stops when the application stops.
 */
@ExperimentalTaskApi
public val TaskService: ApplicationPlugin<TaskServicePluginConfig> =
    createApplicationPlugin(
        name = "TaskServicePlugin",
        createConfiguration = ::TaskServicePluginConfig
    ) {
        val taskService = when (val providedService = pluginConfig.service) {
            is ProvidedTaskService.Service -> providedService.taskService

            is ProvidedTaskService.Values -> KtorTaskService(
                coroutineScope = providedService.coroutineScope
                    ?: CoroutineScope(application.coroutineContext + SupervisorJob()),
                clock = providedService.clock,
                downtimeDuration = providedService.downtimeDuration
            )

            null -> KtorTaskService(
                coroutineScope = CoroutineScope(application.coroutineContext + SupervisorJob()),
                clock = Clock.System,
                downtimeDuration = 15.seconds
            )
        }

        applicationTaskService = taskService

        taskService.start()

        on(MonitoringEvent(ApplicationStarted)) {
            taskService.start()
        }

        on(MonitoringEvent(ApplicationStopped)) {
            taskService.cancel()
        }
    }

/**
 * Provides access to the [TaskService] associated with the current application.
 *
 * The [TaskService] is responsible for managing task scheduling, execution, and lifecycle within the application.
 * This property retrieves the currently configured and installed [TaskService] instance for use in handling tasks.
 *
 * If the [TaskService] is not installed or properly registered, accessing this property will throw a
 * [TaskServiceNotInstalledException].
 *
 * @throws [TaskServiceNotInstalledException]: If a [TaskService] implementation has not been installed.
 *
 * @receiver The current [Application] instance.
 *
 * @return The configured [TaskService] instance.
 */
@ExperimentalTaskApi
@Suppress("UnusedReceiverParameter")
public val Application.taskService: TaskService
    get() = applicationTaskService ?: throw TaskServiceNotInstalledException()

@ExperimentalTaskApi
private var applicationTaskService: TaskService? = null

/**
 * Exception thrown when a TaskService implementation is required but has not been properly installed.
 *
 * This exception may occur in contexts where a [TaskService] is expected to be available for scheduling
 * or managing tasks, but the service has not been installed, configured, or registered correctly.
 *
 * @param [message] An optional detail message providing more information about the cause of the exception.
 *
 * @param [cause] An optional throwable cause indicating the underlying reason for this exception.
 */
@ExperimentalTaskApi
public class TaskServiceNotInstalledException public constructor(
    message: String? = null,
    cause: Throwable? = null
) : RuntimeException(message, cause)

@OptIn(ExperimentalTaskApi::class)
private fun Application.module(){
    install(com.mooncloak.kodetools.ktask.ktor.TaskService)

    this.taskService.launchEnqueue {

    }
}