package com.lightningkite.kommon.bytes


/**
 * Transforms a [Byte] to an [Int] as if it were unsigned.
 * Created by jivie on 5/19/16.
 */
@Suppress("NOTHING_TO_INLINE")
inline fun Byte.toIntUnsigned(): Int {
    return (this.toInt() + 0x100) and 0xFF
}

/**
 * Transforms a [Byte] to an [Long] as if it were unsigned.
 * Created by jivie on 5/19/16.
 */
@Suppress("NOTHING_TO_INLINE")
inline fun Byte.toLongUnsigned(): Long {
    return (this.toLong() + 0x100) and 0xFF
}