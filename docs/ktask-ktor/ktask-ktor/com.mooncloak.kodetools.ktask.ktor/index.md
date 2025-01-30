//[ktask-ktor](../../index.md)/[com.mooncloak.kodetools.ktask.ktor](index.md)

# Package-level declarations

## Types

| Name | Summary |
|---|---|
| [TaskServiceNotInstalledException](-task-service-not-installed-exception/index.md) | [common]<br>@[ExperimentalTaskApi](../../../ktask-core/ktask-core/com.mooncloak.kodetools.ktask/-experimental-task-api/index.md)<br>class [TaskServiceNotInstalledException](-task-service-not-installed-exception/index.md)(message: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)? = null, cause: [Throwable](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-throwable/index.html)? = null) : [RuntimeException](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-runtime-exception/index.html)<br>Exception thrown when a TaskService implementation is required but has not been properly installed. |
| [TaskServicePluginConfig](-task-service-plugin-config/index.md) | [common]<br>@[ExperimentalTaskApi](../../../ktask-core/ktask-core/com.mooncloak.kodetools.ktask/-experimental-task-api/index.md)<br>class [TaskServicePluginConfig](-task-service-plugin-config/index.md)<br>Configuration class for defining and providing a TaskService to the TaskService Plugin. |

## Properties

| Name | Summary |
|---|---|
| [TaskService](-task-service.md) | [common]<br>@[ExperimentalTaskApi](../../../ktask-core/ktask-core/com.mooncloak.kodetools.ktask/-experimental-task-api/index.md)<br>val [TaskService](-task-service.md): ApplicationPlugin&lt;[TaskServicePluginConfig](-task-service-plugin-config/index.md)&gt;<br>Application plugin that provides task management functionalities through a customizable [TaskService](../../../ktask-core/ktask-core/com.mooncloak.kodetools.ktask/-task-service/index.md). |
| [taskService](task-service.md) | [common]<br>@[ExperimentalTaskApi](../../../ktask-core/ktask-core/com.mooncloak.kodetools.ktask/-experimental-task-api/index.md)<br>val Application.[taskService](task-service.md): [TaskService](../../../ktask-core/ktask-core/com.mooncloak.kodetools.ktask/-task-service/index.md)<br>Provides access to the [TaskService](../../../ktask-core/ktask-core/com.mooncloak.kodetools.ktask/-task-service/index.md) associated with the current application. |
