package com.lightningkite.kommon.atomic


actual class AtomicValue<T> actual constructor(value_: T) {

    actual var value: T = value_

    actual fun compareAndSet(expected: T, new: T): Boolean {
        if (expected == value) {
            value = new
            return true
        }
        return false
    }
}
