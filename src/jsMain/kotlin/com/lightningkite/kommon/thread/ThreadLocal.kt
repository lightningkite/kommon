package com.lightningkite.kommon.thread

import com.lightningkite.kommon.property.MutablePropertyDelegate

actual class ThreadLocal<T> actual constructor(startValue: T) : MutablePropertyDelegate<T> {
    override var value: T = startValue
}