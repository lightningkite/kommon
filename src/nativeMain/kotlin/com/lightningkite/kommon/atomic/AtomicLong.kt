package com.lightningkite.kommon.atomic

import com.lightningkite.kommon.property.MutablePropertyDelegate

actual class AtomicLong(val base: kotlin.native.concurrent.AtomicLong): MutablePropertyDelegate<Long> {

    actual constructor(value: Long):this(kotlin.native.concurrent.AtomicLong(value))

    actual override var value: Long
        get() = base.value
        set(value) { base.value = value }

    actual fun addAndGet(delta: Long): Long = base.addAndGet(delta)
    actual fun compareAndSet(expected: Long, new: Long): Boolean = base.compareAndSet(expected, new)
    actual fun increment() = base.increment()
    actual fun decrement() = base.decrement()

}
