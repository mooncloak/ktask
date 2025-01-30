//[ktask-ktor](../../../index.md)/[com.mooncloak.kodetools.ktask.ktor](../index.md)/[TaskServiceNotInstalledException](index.md)

# TaskServiceNotInstalledException

@[ExperimentalTaskApi](../../../../ktask-core/ktask-core/com.mooncloak.kodetools.ktask/-experimental-task-api/index.md)

class [TaskServiceNotInstalledException](index.md)(message: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)? = null, cause: [Throwable](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-throwable/index.html)? = null) : [RuntimeException](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-runtime-exception/index.html)

Exception thrown when a TaskService implementation is required but has not been properly installed.

This exception may occur in contexts where a [TaskService](../../../../ktask-core/ktask-core/com.mooncloak.kodetools.ktask/-task-service/index.md) is expected to be available for scheduling or managing tasks, but the service has not been installed, configured, or registered correctly.

#### Parameters

common

| | |
|---|---|
| message | An optional detail message providing more information about the cause of the exception. |
| cause | An optional throwable cause indicating the underlying reason for this exception. |

## Constructors

| | |
|---|---|
| [TaskServiceNotInstalledException](-task-service-not-installed-exception.md) | [common]<br>constructor(message: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)? = null, cause: [Throwable](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-throwable/index.html)? = null) |

## Properties

| Name | Summary |
|---|---|
| [cause](index.md#-654012527%2FProperties%2F671554627) | [common]<br>open val [cause](index.md#-654012527%2FProperties%2F671554627): [Throwable](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-throwable/index.html)? |
| [message](index.md#1824300659%2FProperties%2F671554627) | [common]<br>open val [message](index.md#1824300659%2FProperties%2F671554627): [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)? |
