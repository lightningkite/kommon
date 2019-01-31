package com.lightningkite.kommon.atomic


actual class AtomicInt actual constructor(value_: Int) {

    actual var value: Int = value_

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
}
