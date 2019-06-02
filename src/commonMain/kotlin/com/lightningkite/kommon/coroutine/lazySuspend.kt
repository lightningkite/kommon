package com.lightningkite.kommon.coroutine

import com.lightningkite.kommon.atomic.AtomicReference
import com.lightningkite.kommon.atomic.AtomicValue

inline fun <T> lazySuspend(crossinline action: suspend () -> T): suspend () -> T {
    val storedValue = AtomicReference<T?>(null)
    return {
        storedValue.value ?: run {
            val newValue = action()
            storedValue.value = newValue
            newValue
        }
    }
}