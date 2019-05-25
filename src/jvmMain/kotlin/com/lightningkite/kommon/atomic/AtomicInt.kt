package com.lightningkite.kommon.atomic

import com.lightningkite.kommon.property.MutablePropertyDelegate


actual class AtomicInt(val backing: java.util.concurrent.atomic.AtomicInteger) : MutablePropertyDelegate<Int> {
    actual constructor(value: Int):this(java.util.concurrent.atomic.AtomicInteger(value))

    actual override var value: Int
        get() = backing.get()
        set(value) {
            backing.set(value)
        }

    actual fun compareAndSet(expected: Int, new: Int): Boolean = backing.compareAndSet(expected, new)
    actual fun addAndGet(delta: Int): Int = backing.addAndGet(delta)
    actual fun increment() {
        backing.incrementAndGet()
    }

    actual fun decrement() {
        backing.decrementAndGet()
    }
}
