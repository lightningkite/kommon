package com.lightningkite.kommon.atomic

import com.lightningkite.kommon.property.MutablePropertyDelegate
import kotlin.test.expect

actual class AtomicInt(val base: kotlin.native.concurrent.AtomicInt): MutablePropertyDelegate<Int> {

    actual constructor(value: Int):this(kotlin.native.concurrent.AtomicInt(value))

    actual override var value: Int
        get() = base.value
        set(value) { base.value = value }

    actual fun addAndGet(delta: Int): Int = base.addAndGet(delta)
    actual fun compareAndSet(expected: Int, new: Int): Boolean = base.compareAndSet(expected, new)
    actual fun increment() = base.increment()
    actual fun decrement() = base.decrement()

}
