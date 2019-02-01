package com.lightningkite.kommon.atomic

expect class AtomicInt(value_: Int) {
    var value: Int
    fun addAndGet(delta: Int): Int
    fun compareAndSet(expected: Int, new: Int): Boolean
}

fun AtomicInt.increment() {
    addAndGet(1)
}

fun AtomicInt.decrement() {
    addAndGet(-1)
}
