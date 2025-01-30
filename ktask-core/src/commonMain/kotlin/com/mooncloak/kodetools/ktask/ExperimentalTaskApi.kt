package com.mooncloak.kodetools.ktask

/**
 * Marks the annotated task related API as experimental and subject to change in the future.
 *
 * Any usage of a component annotated with this marker will produce a warning unless it is explicitly opted into by
 * using the `@OptIn` annotation or by enabling the specific compiler option.
 *
 * This annotation is intended to denote functionality that is still being developed or tested and may be unstable or
 * have breaking changes in subsequent versions.
 */
@MustBeDocumented
@RequiresOptIn(
    level = RequiresOptIn.Level.WARNING,
    message = "This API is experimental and is likely to change in the future."
)
public annotation class ExperimentalTaskApi public constructor()
