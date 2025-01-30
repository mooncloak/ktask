package com.mooncloak.kodetools.ktask

import kotlinx.datetime.Clock
import kotlinx.datetime.Instant
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue
import kotlin.time.Duration
import kotlin.time.Duration.Companion.seconds
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

@OptIn(ExperimentalTaskApi::class)
class TaskTest {

    @Test
    fun estimated_runtime_equals_scheduled_if_delay_is_null() {
        val task = createTask(delay = null)

        assertEquals(expected = task.scheduled, actual = task.estimatedRuntime)
    }

    @Test
    fun estimated_runtime_equals_scheduled_plus_delay() {
        val task = createTask(delay = 15.seconds)

        assertEquals(expected = task.scheduled + 15.seconds, actual = task.estimatedRuntime)
    }

    @Test
    fun should_run_again_returns_true_if_replay_is_not_zero() {
        var task = createTask(replay = 0)

        assertFalse { task.shouldRunAgain() }

        task = createTask(replay = 1)

        assertTrue { task.shouldRunAgain() }

        task = createTask(replay = -1)

        assertTrue { task.shouldRunAgain() }
    }

    @Test
    fun is_runnable_at_returns_true_if_now_is_greater_than_scheduled() {
        val now = Clock.System.now()
        val task = createTask(scheduled = now)

        assertTrue { task.isRunnableAt(instant = now + 1.seconds) }
    }

    @Test
    fun is_runnable_at_returns_false_if_now_is_less_than_scheduled() {
        val now = Clock.System.now()
        val task = createTask(scheduled = now)

        assertFalse { task.isRunnableAt(instant = now - 1.seconds) }
    }

    @Test
    fun is_runnable_at_returns_false_if_now_is_equal_to_scheduled() {
        val now = Clock.System.now()
        val task = createTask(scheduled = now)

        assertFalse { task.isRunnableAt(instant = now) }
    }

    @Test
    fun is_runnable_at_returns_true_if_now_is_greater_than_scheduled_plus_delay() {
        val now = Clock.System.now()
        val task = createTask(
            scheduled = now,
            delay = 15.seconds
        )

        assertTrue { task.isRunnableAt(instant = now + 16.seconds) }
    }

    @Test
    fun is_runnable_at_returns_false_if_now_is_less_than_scheduled_plus_delay() {
        val now = Clock.System.now()
        val task = createTask(
            scheduled = now,
            delay = 15.seconds
        )

        assertFalse { task.isRunnableAt(instant = now + 14.seconds) }
    }

    @Test
    fun is_runnable_at_returns_false_if_now_is_equal_to_scheduled_plus_delay() {
        val now = Clock.System.now()
        val task = createTask(
            scheduled = now,
            delay = 15.seconds
        )

        assertFalse { task.isRunnableAt(instant = now + 15.seconds) }
    }

    @OptIn(ExperimentalUuidApi::class)
    private fun createTask(
        id: String = Uuid.random().toHexString(),
        type: String? = null,
        scheduled: Instant = Clock.System.now(),
        delay: Duration? = null,
        interval: Duration? = null,
        replay: Int = 0,
        value: suspend () -> Unit = {}
    ): Task = object : DefaultTask(
        id = id,
        type = type,
        scheduled = scheduled,
        delay = delay,
        interval = interval,
        replay = replay
    ) {

        override suspend fun invoke() {
            value.invoke()
        }
    }
}
