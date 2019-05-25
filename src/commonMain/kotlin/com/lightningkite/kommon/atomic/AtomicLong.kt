package com.lightningkite.kommon.atomic

import com.lightningkite.kommon.property.MutablePropertyDelegate

expect class AtomicLong(value: Long): MutablePropertyDelegate<Long> {
    override var value: Long
    fun addAndGet(delta: Long): Long
    fun compareAndSet(expected: Long, new: Long): Boolean
    fun increment()
    fun decrement()
}
