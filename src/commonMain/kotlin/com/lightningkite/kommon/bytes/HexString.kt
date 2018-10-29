package com.lightningkite.kommon.bytes

private val chars = charArrayOf(
        '0',
        '1',
        '2',
        '3',
        '4',
        '5',
        '6',
        '7',
        '8',
        '9',
        'a',
        'b',
        'c',
        'd',
        'e',
        'f'
)

fun Int.toHexString() = StringBuilder(8)
        .append(chars[this ushr 28 and 0xF])
        .append(chars[this ushr 24 and 0xF])
        .append(chars[this ushr 20 and 0xF])
        .append(chars[this ushr 16 and 0xF])
        .append(chars[this ushr 12 and 0xF])
        .append(chars[this ushr 8 and 0xF])
        .append(chars[this ushr 4 and 0xF])
        .append(chars[this ushr 0 and 0xF])
        .toString()