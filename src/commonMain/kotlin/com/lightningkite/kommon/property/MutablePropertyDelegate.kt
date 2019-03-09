package com.lightningkite.kommon.property

import kotlin.reflect.KProperty

interface MutablePropertyDelegate<T> : PropertyDelegate<T> {
    override var value: T
    operator fun setValue(thisRef: Any?, prop: KProperty<*>, v: T) {
        value = v
    }
}