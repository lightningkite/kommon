package com.lightningkite.kommon.atomic

expect class AtomicLong(value_: Long) {
    var value: Long
    fun addAndGet(delta: Long): Long
    fun compareAndSet(expected: Long, new: Long): Boolean
}

fun AtomicLong.increment() {
    addAndGet(1)
}

fun AtomicLong.decrement() {
    addAndGet(-1)
}
