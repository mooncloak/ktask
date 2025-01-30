//[ktask-core](../../index.md)/[com.mooncloak.kodetools.ktask](index.md)/[shouldRunAgain](should-run-again.md)

# shouldRunAgain

[common]\

@[ExperimentalTaskApi](-experimental-task-api/index.md)

fun [Task](-task/index.md).[shouldRunAgain](should-run-again.md)(): [Boolean](https://kotlinlang.org/api/core/kotlin-stdlib/kotlin/-boolean/index.html)

Determines if the task should run again based on its [Task.replay](-task/replay.md) value.

If the [Task.replay](-task/replay.md) value is less than zero, then it should be rerun indefinitely, Otherwise, the [Task.replay](-task/replay.md) indicates how many more times the [Task](-task/index.md) should be run.

#### Return

`true` if the task's replay property is not equal to 0, otherwise `false`.
