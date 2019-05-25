package com.lightningkite.kommon.atomic

import com.lightningkite.kommon.property.MutablePropertyDelegate


actual class AtomicLong(val backing: java.util.concurrent.atomic.AtomicLong) : MutablePropertyDelegate<Long> {
    actual constructor(value: Long):this(java.util.concurrent.atomic.AtomicLong(value))

    actual override var value: Long
        get() = backing.get()
        set(value) {
            backing.set(value)
        }

    actual fun compareAndSet(expected: Long, new: Long): Boolean = backing.compareAndSet(expected, new)
    actual fun addAndGet(delta: Long): Long = backing.addAndGet(delta)
    actual fun increment() {
        backing.incrementAndGet()
    }

    actual fun decrement() {
        backing.decrementAndGet()
    }
}
