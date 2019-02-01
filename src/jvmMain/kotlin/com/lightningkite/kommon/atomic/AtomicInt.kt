package com.lightningkite.kommon.atomic


actual class AtomicInt actual constructor(value_: Int) {
    val backing = java.util.concurrent.atomic.AtomicInteger(value_)

    actual var value: Int
        get() = backing.get()
        set(value) {
            backing.set(value)
        }

    actual fun compareAndSet(expected: Int, new: Int): Boolean = backing.compareAndSet(expected, new)
    actual fun addAndGet(delta: Int): Int = backing.addAndGet(delta)
}
