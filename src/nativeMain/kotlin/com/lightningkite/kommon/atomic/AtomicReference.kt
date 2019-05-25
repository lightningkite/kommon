package com.lightningkite.kommon.atomic

import com.lightningkite.kommon.property.MutablePropertyDelegate

actual class AtomicReference<T>(val base: kotlin.native.concurrent.AtomicReference<T>): MutablePropertyDelegate<T> {

    actual constructor(value: T):this(kotlin.native.concurrent.AtomicReference<T>(value))

    actual override var value: T
        get() = base.value
        set(value) { base.value = value }

    actual fun compareAndSet(expected: T, new: T): Boolean = base.compareAndSet(expected, new)

}

