//[ktask-core](../../../index.md)/[com.mooncloak.kodetools.ktask](../index.md)/[TaskQueue](index.md)/[clear](clear.md)

# clear

[common]\
abstract suspend fun [clear](clear.md)()

Clears all tasks from the task queue.

This method removes all tasks, ensuring that the queue becomes empty. Any operations relying on the presence of tasks in the queue may be affected after calling this method. It is intended to reset the task queue to an initial state without any queued tasks.
