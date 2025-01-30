package com.mooncloak.kodetools.ktask.ktor

import com.mooncloak.kodetools.ktask.ExperimentalTaskApi
import com.mooncloak.kodetools.ktask.Task
import kotlinx.datetime.Instant
import kotlin.time.Duration
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

@ExperimentalTaskApi
@OptIn(ExperimentalUuidApi::class)
internal operator fun Task.Companion.invoke(
    id: String = Uuid.random().toHexString(),
    type: String? = null,
    scheduled: Instant,
    delay: Duration? = null,
    interval: Duration? = null,
    replay: Int = 0,
    value: suspend () -> Unit
): Task = KtorTask(
    id = id,
    type = type,
    scheduled = scheduled,
    delay = delay,
    interval = interval,
    replay = replay,
    value = value
)

@ExperimentalTaskApi
@OptIn(ExperimentalUuidApi::class)
internal data class KtorTask internal constructor(
    override val id: String = Uuid.random().toHexString(),
    override val type: String? = null,
    override val scheduled: Instant,
    override val delay: Duration? = null,
    override val interval: Duration? = null,
    override val replay: Int = 0,
    internal val value: suspend () -> Unit
) : Task {

    override suspend fun invoke() {
        value.invoke()
    }

    override fun copy(
        id: String,
        type: String?,
        scheduled: Instant,
        delay: Duration?,
        interval: Duration?,
        replay: Int
    ): Task = KtorTask(
        id = id,
        type = type,
        scheduled = scheduled,
        delay = delay,
        interval = interval,
        replay = replay,
        value = this.value
    )
}
