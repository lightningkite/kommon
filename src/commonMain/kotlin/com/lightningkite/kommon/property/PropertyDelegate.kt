package com.lightningkite.kommon.property

import kotlin.reflect.KProperty

interface PropertyDelegate<T> {
    val value: T

    /**
     * Simply retrieves the value.
     * Used for property delegates.
     */
    operator fun getValue(thisRef: Any?, prop: KProperty<*>): T = value
}

