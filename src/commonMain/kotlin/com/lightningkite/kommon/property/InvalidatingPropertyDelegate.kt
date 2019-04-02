package com.lightningkite.kommon.property


class InvalidatingPropertyDelegate<T>(val calculation: () -> T) : PropertyDelegate<T> {
    var dirty: Boolean = false
    override var value: T = calculation()
        get() {
            if (dirty) {
                field = calculation()
                dirty = false
            }
            return field
        }
}