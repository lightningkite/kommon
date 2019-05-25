package com.lightningkite.kommon.atomic

import com.lightningkite.kommon.property.MutablePropertyDelegate


actual class AtomicValue<T> actual constructor(actual override var value: T): MutablePropertyDelegate<T> {

    actual fun compareAndSet(expected: T, new: T): Boolean {
        if (expected == value) {
            value = new
            return true
        }
        return false
    }
}
