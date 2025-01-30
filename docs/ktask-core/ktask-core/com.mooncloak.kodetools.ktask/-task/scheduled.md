//[ktask-core](../../../index.md)/[com.mooncloak.kodetools.ktask](../index.md)/[Task](index.md)/[scheduled](scheduled.md)

# scheduled

[common]\
abstract val [scheduled](scheduled.md): Instant

The Instant the task was scheduled for execution by placing it in the task service's queue. Note that this is not the time when the task will run. If you want an estimate of when the task will run, use the [estimatedRuntime](../estimated-runtime.md) property.
