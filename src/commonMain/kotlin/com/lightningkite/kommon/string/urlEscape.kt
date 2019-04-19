package com.lightningkite.kommon.string

fun String.urlEscape() = buildString {
    for (c in this) {
        when (c) {
            in 'A'..'Z',
            in 'a'..'z',
            in '0'..'9',
            ',', '.', '-', '_' -> append(c)
            else -> {
                append('%')
                append(c.toInt().toString(16).takeLast(2))
            }
        }
    }
}

fun String.urlUnescape() = buildString {
    var index = 0
    while (index < length) {
        val c = this[index]
        when (c) {
            '%' -> {
                if (index + 2 < length) {
                    val substr = this.substring(index + 1, index + 3)
                    val charValue = substr.toInt(16)
                    append(charValue.toChar())
                } else {
                    append('%')
                }
            }
            else -> append(c)
        }
        index++
    }
}
