//[ktask-core](../../../index.md)/[com.mooncloak.kodetools.ktask](../index.md)/[TaskService](index.md)/[events](events.md)

# events

[common]\
abstract val [events](events.md): SharedFlow&lt;[TaskEvent](../-task-event/index.md)&gt;

A shared flow that emits events related to tasks managed by the [TaskService](index.md).

The [events](events.md) flow provides a stream of [TaskEvent](../-task-event/index.md)`s that represent changes in the state of tasks within the service. Subscribers to this flow can observe various task-related events, such as when a task is scheduled, removed, executing, completed, or failed. Each type of [TaskEvent](../-task-event/index.md) carries specific details relevant to the event type.

This property allows consumers to react to task state changes, enabling further integration or logging based on task lifecycle events.

#### See also

| |
|---|
| [TaskEvent](../-task-event/index.md) |
