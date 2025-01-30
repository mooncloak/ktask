//[ktask-core](../../../index.md)/[com.mooncloak.kodetools.ktask](../index.md)/[DefaultTask](index.md)/[copy](copy.md)

# copy

[common]\
override fun [copy](copy.md)(id: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html), type: [String](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-string/index.html)?, scheduled: Instant, delay: [Duration](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.time/-duration/index.html)?, interval: [Duration](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin.time/-duration/index.html)?, replay: [Int](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-int/index.html)): [Task](../-task/index.md)

Creates a copy of this task with optional overrides for its properties.

#### Return

a new instance of the task with the specified parameters.

#### Parameters

common

| | |
|---|---|
| id | the unique identifier for the task. Defaults to the value from the existing task. Note that [Task.id](../-task/id.md) values MUST be unique, so adding a [Task](../-task/index.md) to a [TaskService](../-task-service/index.md) with the same identifier value will typically override the previous value. Though, it is up to the implementation of [TaskService](../-task-service/index.md) to define that behavior. |
| type | an optional type or category for the task. Defaults to the value from the existing task. |
| scheduled | the scheduled time for the task. Defaults to the value from the existing task. |
| delay | an optional delay before the task becomes executable. Defaults to the value from the existing task. |
| interval | an optional interval defining the time between repeated executions. Defaults to the value from the existing task. |
| replay | the number of additional executions allowed. Defaults to the value from the existing task. |
