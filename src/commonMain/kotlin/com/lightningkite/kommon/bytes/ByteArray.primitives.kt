package com.lightningkite.kommon.bytes

fun ByteArray.getShort(startingAt: Int): Short {
    if(startingAt > size - 1) throw IndexOutOfBoundsException()
    return (this[startingAt].toIntUnsigned().shl(8) or this[startingAt+1].toIntUnsigned()).toShort()
}
fun ByteArray.setShort(startingAt: Int, value: Short) {
    if(startingAt > size - 1) throw IndexOutOfBoundsException()
    val asInt = value.toInt()
    this[startingAt] = asInt.shr(8).and(0xFF).toByte()
    this[startingAt + 1] = asInt.and(0xFF).toByte()
}

fun ByteArray.getInt(startingAt: Int): Int {
    if(startingAt > size - 3) throw IndexOutOfBoundsException()
    return (
            this[startingAt].toIntUnsigned().shl(24) or
            this[startingAt+1].toIntUnsigned().shl(16) or
            this[startingAt+2].toIntUnsigned().shl(8) or
            this[startingAt+3].toIntUnsigned()
    )
}
fun ByteArray.setInt(startingAt: Int, value: Int) {
    if(startingAt > size - 3) throw IndexOutOfBoundsException()
    this[startingAt] = value.ushr(24).and(0xFF).toByte()
    this[startingAt + 1] = value.shr(16).and(0xFF).toByte()
    this[startingAt + 2] = value.shr(8).and(0xFF).toByte()
    this[startingAt + 3] = value.and(0xFF).toByte()
}

fun ByteArray.getLong(startingAt: Int): Long {
    if(startingAt > size - 7) throw IndexOutOfBoundsException()
    return (
            this[startingAt].toLongUnsigned().shl(56) or
            this[startingAt+1].toLongUnsigned().shl(48) or
            this[startingAt+2].toLongUnsigned().shl(40) or
            this[startingAt+3].toLongUnsigned().shl(32) or
            this[startingAt+4].toLongUnsigned().shl(24) or
            this[startingAt+5].toLongUnsigned().shl(16) or
            this[startingAt+6].toLongUnsigned().shl(8) or
            this[startingAt+7].toLongUnsigned()
    )
}
fun ByteArray.setLong(startingAt: Int, value: Long) {
    if(startingAt > size - 7) throw IndexOutOfBoundsException()
    this[startingAt + 0] = value.ushr(56).and(0xFF).toByte()
    this[startingAt + 1] = value.shr(48).and(0xFF).toByte()
    this[startingAt + 2] = value.shr(40).and(0xFF).toByte()
    this[startingAt + 3] = value.shr(32).and(0xFF).toByte()
    this[startingAt + 4] = value.shr(24).and(0xFF).toByte()
    this[startingAt + 5] = value.shr(16).and(0xFF).toByte()
    this[startingAt + 6] = value.shr(8).and(0xFF).toByte()
    this[startingAt + 7] = value.and(0xFF).toByte()
}