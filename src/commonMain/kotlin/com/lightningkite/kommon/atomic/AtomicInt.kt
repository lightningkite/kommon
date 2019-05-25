package com.lightningkite.kommon.atomic

import com.lightningkite.kommon.property.MutablePropertyDelegate

expect class AtomicInt(value: Int): MutablePropertyDelegate<Int> {
    override var value: Int
    fun addAndGet(delta: Int): Int
    fun compareAndSet(expected: Int, new: Int): Boolean
    fun increment()
    fun decrement()
}
