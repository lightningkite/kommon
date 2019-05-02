package com.lightningkite.kommon.atomic

import kotlin.native.concurrent.ThreadLocal
import kotlin.native.concurrent.freeze

actual class AtomicValue<T> actual constructor(value_: T) {

    private val lock = Lock()
    var backing: T = value_
    actual var value: T
        get() {
            return backing
        }
        set(value){
            locked(lock){
                backing = value
            }
        }

    actual fun compareAndSet(expected: T, new: T): Boolean {
        var result = false
        locked(lock){
            if (expected == value) {
                value = new
                result = true
            }
        }
        return result
    }
}

//Directly from kotlin internals

@ThreadLocal
private object CurrentThread {
    val id = Any().freeze()
}


internal class Lock {
    private val locker_ = AtomicInt(0)
    private val reenterCount_ = AtomicInt(0)

    // TODO: make it properly reschedule instead of spinning.
    fun lock() {
        val lockData = CurrentThread.id.hashCode()
        loop@ do {
            val old = locker_.compareAndSwap(0, lockData)
            when (old) {
                lockData -> {
                    // Was locked by us already.
                    reenterCount_.increment()
                    break@loop
                }
                0 -> {
                    // We just got the lock.
                    assert(reenterCount_.value == 0)
                    break@loop
                }
            }
        } while (true)
    }

    fun unlock() {
        if (reenterCount_.value > 0) {
            reenterCount_.decrement()
        } else {
            val lockData = CurrentThread.id.hashCode()
            val old = locker_.compareAndSwap(lockData, 0)
            assert(old == lockData)
        }
    }
}

internal inline fun <R> locked(lock: Lock, block: () -> R): R {
    lock.lock()
    try {
        return block()
    } finally {
        lock.unlock()
    }
}