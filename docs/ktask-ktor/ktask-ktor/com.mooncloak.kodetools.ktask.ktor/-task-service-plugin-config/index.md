//[ktask-ktor](../../../index.md)/[com.mooncloak.kodetools.ktask.ktor](../index.md)/[TaskServicePluginConfig](index.md)

# TaskServicePluginConfig

[common]\
@[ExperimentalTaskApi](../../../../ktask-core/ktask-core/com.mooncloak.kodetools.ktask/-experimental-task-api/index.md)

class [TaskServicePluginConfig](index.md)

Configuration class for defining and providing a TaskService to the TaskService Plugin.

This class allows customization of the TaskService by providing different configurations. It supports two approaches to set up the service:

- 
   Providing an existing [TaskService](../../../../ktask-core/ktask-core/com.mooncloak.kodetools.ktask/-task-service/index.md) implementation.
- 
   Defining specific attributes for the service, such as coroutine scope, clock, and downtime duration.

The configured [TaskService](../../../../ktask-core/ktask-core/com.mooncloak.kodetools.ktask/-task-service/index.md) can manage the scheduling, execution, and lifecycle of tasks according to the provided parameters.

## Constructors

| | |
|---|---|
| [TaskServicePluginConfig](-task-service-plugin-config.md) | [common]<br>constructor() |

## Functions

| Name | Summary |
|---|---|
| [service](service.md) | [common]<br>fun [service](service.md)(taskService: [TaskService](../../../../ktask-core/ktask-core/com.mooncloak.kodetools.ktask/-task-service/index.md))<br>Configures the [TaskService](../../../../ktask-core/ktask-core/com.mooncloak.kodetools.ktask/-task-service/index.md) for the TaskService Plugin.<br>[common]<br>fun [service](service.md)(coroutineScope: CoroutineScope? = null, clock: Clock = Clock.System, downtimeDuration: [Duration](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.time/-duration/index.html) = 15.seconds)<br>Configures the TaskService with the specified parameters. |
