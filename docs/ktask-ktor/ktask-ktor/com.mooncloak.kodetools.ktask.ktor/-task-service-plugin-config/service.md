//[ktask-ktor](../../../index.md)/[com.mooncloak.kodetools.ktask.ktor](../index.md)/[TaskServicePluginConfig](index.md)/[service](service.md)

# service

[common]\
fun [service](service.md)(taskService: [TaskService](../../../../ktask-core/ktask-core/com.mooncloak.kodetools.ktask/-task-service/index.md))

Configures the [TaskService](../../../../ktask-core/ktask-core/com.mooncloak.kodetools.ktask/-task-service/index.md) for the TaskService Plugin.

This function allows providing an existing implementation of [TaskService](../../../../ktask-core/ktask-core/com.mooncloak.kodetools.ktask/-task-service/index.md) to configure the service. The provided [TaskService](../../../../ktask-core/ktask-core/com.mooncloak.kodetools.ktask/-task-service/index.md) will be encapsulated within a `ProvidedTaskService.Service` instance.

#### Parameters

common

| | |
|---|---|
| taskService | the implementation of [TaskService](../../../../ktask-core/ktask-core/com.mooncloak.kodetools.ktask/-task-service/index.md) to be used for managing task scheduling, execution, and lifecycle. |

[common]\
fun [service](service.md)(coroutineScope: CoroutineScope? = null, clock: Clock = Clock.System, downtimeDuration: [Duration](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.time/-duration/index.html) = 15.seconds)

Configures the TaskService with the specified parameters.

This method allows customization of the TaskService by defining specific attributes, such as a coroutine scope, a clock for time management, and the downtime duration.

#### Parameters

common

| | |
|---|---|
| coroutineScope | the coroutine scope to manage the lifecycle of tasks. If `null`, a CoroutineScope will be created that associated with the Application.coroutineContext. Defaults to `null`. |
| clock | the clock used for time management within the TaskService. Defaults to the system clock. |
| downtimeDuration | the duration of downtime for the TaskService. When there are no more tasks to execute, the [TaskService](../../../../ktask-core/ktask-core/com.mooncloak.kodetools.ktask/-task-service/index.md) will delay for this period of time before checking if more tasks were added. This allows the [TaskService](../../../../ktask-core/ktask-core/com.mooncloak.kodetools.ktask/-task-service/index.md) to not exhaust system resources. Defaults to 15 seconds. |
