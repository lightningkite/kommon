package com.lightningkite.kommon.thread

import com.lightningkite.kommon.collection.WeakHashMap
import com.lightningkite.kommon.property.MutablePropertyDelegate
import kotlin.native.concurrent.freeze
import kotlin.native.concurrent.ThreadLocal as ThreadLocalAnnotation
import kotlin.native.ref.WeakReference

@ThreadLocalAnnotation
val items = WeakHashMap<ThreadLocal<*>, Any?>()

actual class ThreadLocal<T> actual constructor(startValue: T) : MutablePropertyDelegate<T> {
    init {
        items[this] = startValue
        freeze()
    }
    @Suppress("UNCHECKED_CAST")
    override var value: T
        get() = items[this] as T
        set(value) {
            items[this] = value
        }
}