package com.lightningkite.kommon.atomic

import com.lightningkite.kommon.property.MutablePropertyDelegate


actual class AtomicValue<T> actual constructor(value: T): MutablePropertyDelegate<T> {
    var backing = value

    @set:Synchronized actual override var value: T
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
