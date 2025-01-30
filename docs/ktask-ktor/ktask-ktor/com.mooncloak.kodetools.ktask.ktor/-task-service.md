//[ktask-ktor](../../index.md)/[com.mooncloak.kodetools.ktask.ktor](index.md)/[TaskService](-task-service.md)

# TaskService

[common]\

@[ExperimentalTaskApi](../../../ktask-core/ktask-core/com.mooncloak.kodetools.ktask/-experimental-task-api/index.md)

val [TaskService](-task-service.md): ApplicationPlugin&lt;[TaskServicePluginConfig](-task-service-plugin-config/index.md)&gt;

Application plugin that provides task management functionalities through a customizable [TaskService](../../../ktask-core/ktask-core/com.mooncloak.kodetools.ktask/-task-service/index.md).

The `TaskService` plugin is responsible for managing scheduled and ad-hoc tasks within an application. It initializes an instance of the [TaskService](../../../ktask-core/ktask-core/com.mooncloak.kodetools.ktask/-task-service/index.md) (either provided externally or created internally) and ensures the lifecycle of the service aligns with the application's lifecycle.

Configuration of the plugin allows users to supply a pre-existing task service or configure one with custom parameters such as coroutine scope, clock instance, and downtime duration.

Initialization Behavior:

- 
   If a task service is provided, it uses the provided service instance.
- 
   If no service is provided, it creates an instance of `KtorTaskService` with default parameters or the ones specified in the plugin configuration.

During the application lifecycle:

- 
   The task service starts when the application starts.
- 
   The task service cancels and stops when the application stops.
