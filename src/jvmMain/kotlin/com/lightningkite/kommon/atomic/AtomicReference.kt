package com.lightningkite.kommon.atomic

import com.lightningkite.kommon.property.MutablePropertyDelegate


actual class AtomicReference<T>(val backing: java.util.concurrent.atomic.AtomicReference<T>): MutablePropertyDelegate<T> {
    actual constructor(value: T):this(java.util.concurrent.atomic.AtomicReference<T>(value))

    actual override var value: T
        get() = backing.get()
        set(value) {
            backing.set(value)
        }

    actual fun compareAndSet(expected: T, new: T): Boolean = backing.compareAndSet(expected, new)
}
