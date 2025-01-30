//[ktask-ktor](../../index.md)/[com.mooncloak.kodetools.ktask.ktor](index.md)/[taskService](task-service.md)

# taskService

[common]\

@[ExperimentalTaskApi](../../../ktask-core/ktask-core/com.mooncloak.kodetools.ktask/-experimental-task-api/index.md)

val Application.[taskService](task-service.md): [TaskService](../../../ktask-core/ktask-core/com.mooncloak.kodetools.ktask/-task-service/index.md)

Provides access to the [TaskService](../../../ktask-core/ktask-core/com.mooncloak.kodetools.ktask/-task-service/index.md) associated with the current application.

The [TaskService](../../../ktask-core/ktask-core/com.mooncloak.kodetools.ktask/-task-service/index.md) is responsible for managing task scheduling, execution, and lifecycle within the application. This property retrieves the currently configured and installed [TaskService](../../../ktask-core/ktask-core/com.mooncloak.kodetools.ktask/-task-service/index.md) instance for use in handling tasks.

If the [TaskService](../../../ktask-core/ktask-core/com.mooncloak.kodetools.ktask/-task-service/index.md) is not installed or properly registered, accessing this property will throw a [TaskServiceNotInstalledException](-task-service-not-installed-exception/index.md).

#### Receiver

The current Application instance.

#### Return

The configured [TaskService](../../../ktask-core/ktask-core/com.mooncloak.kodetools.ktask/-task-service/index.md) instance.

#### Throws

| | |
|---|---|
| [TaskServiceNotInstalledException](-task-service-not-installed-exception/index.md) | : If a [TaskService](../../../ktask-core/ktask-core/com.mooncloak.kodetools.ktask/-task-service/index.md) implementation has not been installed. |
