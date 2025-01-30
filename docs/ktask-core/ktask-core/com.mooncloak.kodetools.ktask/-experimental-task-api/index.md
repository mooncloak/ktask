//[ktask-core](../../../index.md)/[com.mooncloak.kodetools.ktask](../index.md)/[ExperimentalTaskApi](index.md)

# ExperimentalTaskApi

[common]\
annotation class [ExperimentalTaskApi](index.md)

Marks the annotated task related API as experimental and subject to change in the future.

Any usage of a component annotated with this marker will produce a warning unless it is explicitly opted into by using the `@OptIn` annotation or by enabling the specific compiler option.

This annotation is intended to denote functionality that is still being developed or tested and may be unstable or have breaking changes in subsequent versions.
