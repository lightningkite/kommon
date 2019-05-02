package com.lightningkite.kommon.atomic


actual class AtomicValue<T> actual constructor(value_: T) {
    var backing = value_

    @set:Synchronized actual var value: T
        get() = backing
        set(value) {
            backing = value
        }

    @Synchronized actual fun compareAndSet(expected: T, new: T): Boolean {
        if (expected == value) {
            value = new
            return true
        }
        return false
    }
}
