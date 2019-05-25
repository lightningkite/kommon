package com.lightningkite.kommon.atomic

import com.lightningkite.kommon.property.MutablePropertyDelegate

expect class AtomicReference<T>(value: T): MutablePropertyDelegate<T> {
    override var value: T
    fun compareAndSet(expected: T, new: T): Boolean
}
