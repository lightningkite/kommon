package com.lightningkite.kommon.atomic

import com.lightningkite.kommon.property.MutablePropertyDelegate


actual class AtomicInt actual constructor(actual override var value: Int): MutablePropertyDelegate<Int> {

    actual fun compareAndSet(expected: Int, new: Int): Boolean {
        if (expected == value) {
            value = new
            return true
        }
        return false
    }

    actual fun addAndGet(delta: Int): Int {
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
