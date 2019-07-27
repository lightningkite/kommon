package com.lightningkite.kommon.thread

import com.lightningkite.kommon.property.MutablePropertyDelegate
import java.lang.ThreadLocal

actual class ThreadLocal<T> actual constructor(startValue: T) : MutablePropertyDelegate<T> {
    val underlying = object : java.lang.ThreadLocal<T>() {
        override fun initialValue(): T = startValue
    }
    override var value: T
        get() = underlying.get()
        set(value) {
            underlying.set(value)
        }
}