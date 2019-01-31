package com.lightningkite.kommon.atomic


actual class AtomicLong actual constructor(value_: Long) {
    val backing = java.util.concurrent.atomic.AtomicLong(value)

    actual var value: Long
        get() = backing.get()
        set(value) {
            backing.set(value)
        }

    actual fun compareAndSet(expected: Long, new: Long): Boolean = backing.compareAndSet(expected, new)
    actual fun addAndGet(delta: Long): Long = backing.addAndGet(delta)
}
