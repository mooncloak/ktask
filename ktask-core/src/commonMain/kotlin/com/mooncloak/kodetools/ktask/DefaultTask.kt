package com.mooncloak.kodetools.ktask

import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlin.time.Duration
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

/**
 * An abstract implementation of the [Task] interface that provides default behavior and property initializations for
 * creating tasks. This class can be extended to define specific executable tasks.
 */
@ExperimentalTaskApi
@OptIn(ExperimentalUuidApi::class)
public abstract class DefaultTask public constructor(
    public override val id: String = Uuid.random().toHexString(),
    public override val type: String? = null,
    public override val delay: Duration? = null,
    public override val interval: Duration? = null,
    public override val replay: Int = 0,
    public final override val scheduled: Instant = Clock.System.now()
) : Task {

    public abstract override suspend operator fun invoke()

    public final override fun copy(
        id: String,
        type: String?,
        scheduled: Instant,
        delay: Duration?,
        interval: Duration?,
        replay: Int
    ): Task = object : DefaultTask(
        id = id,
        type = type,
        scheduled = scheduled,
        delay = delay,
        interval = interval,
        replay = replay
    ) {

        override suspend fun invoke() {
            this@DefaultTask.invoke()
        }
    }

    public companion object
}
