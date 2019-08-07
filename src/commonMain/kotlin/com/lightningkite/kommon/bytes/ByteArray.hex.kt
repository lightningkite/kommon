package com.lightningkite.kommon.bytes


private val hexArray = charArrayOf('0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F')

/**
 * Translates a byte array to a hex string.
 * Uses Big Endian.
 */
fun ByteArray.toStringHex(): String {
    return StringBuilder(size * 2).apply {
        var index = 0
        for (byte in this@toStringHex) {
            val ubyte = (byte.toInt() and 0xFF)
            append(hexArray[ubyte ushr 4])
            append(hexArray[ubyte and 0x0F])
            index++
        }
    }.toString()
}

/**
 * Translates a hex string to a byte array.
 * Uses Big Endian.
 */
fun String.hexToByteArray(): ByteArray {
    val array = ByteArray(length / 2)
    for (i in 0..array.size - 1) {
        array[i] = ((this[i * 2].toHexValue() shl 4) or (this[i * 2 + 1].toHexValue())).toByte()
    }
    return array
}

/**
 * Returns the hex value of a character.
 */
fun Char.toHexValue(): Int {
    return if (this >= 'a') {
        this - 'a' + 10
    } else if (this >= 'A')
        this - 'A' + 10
    else
        this - '0'
}

fun Int.toByteArray() = byteArrayOf(
        (this ushr 24).toByte(),
        (this shr 16).toByte(),
        (this shr 8).toByte(),
        (this).toByte()
)

fun ByteArray.toInt(): Int {
    if (this.size != 4) throw IllegalArgumentException("ByteArray must be 4 bytes long.")
    return this[0].toIntUnsigned().shl(24) or
            this[1].toIntUnsigned().shl(16) or
            this[2].toIntUnsigned().shl(8) or
            this[3].toInt()
}