package com.lightningkite.kommon.atomic

import com.lightningkite.kommon.property.MutablePropertyDelegate


actual class AtomicLong actual constructor(actual override var value: Long): MutablePropertyDelegate<Long> {

    actual fun compareAndSet(expected: Long, new: Long): Boolean {
        if (expected == value) {
            value = new
            return true
        }
        return false
    }

    actual fun addAndGet(delta: Long): Long {
        value += delta
        return value
    }

    actual fun increment() {
        addAndGet(1)
    }

    actual fun decrement() {
        addAndGet(-1)
    }
}
