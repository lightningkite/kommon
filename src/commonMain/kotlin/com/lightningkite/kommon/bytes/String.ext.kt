package com.lightningkite.kommon.bytes

expect fun String.toUTF8ByteArray(): ByteArray
expect fun String.Companion.fromUTF8ByteArray(byteArray: ByteArray): String

expect fun String.toUTF16ByteArray(): ByteArray
expect fun String.Companion.fromUTF16ByteArray(byteArray: ByteArray): String

//fun String.toUTF8ByteArray():ByteArray{
//
//    val size = sumBy {
//        when{
//            it <= '\u007F' -> 1
//            it <= '\u0800' -> 2
//            it in '\ud800' .. '\uE000' -> 3
//            else ->4
//        }
//    }
//
//    val utf8 = ByteArray(size)
//    val str = this
//    var writeIndex = 0
//    var readIndex = 0
//    while (readIndex < str.length) {
//        val it = str[readIndex]
//        val itAsInt = it.toInt()
//        when{
//            it <= '\u007F' -> {
//                utf8[writeIndex++] = it.toByte()
//            }
//            it <= '\u0800' -> {
//                utf8[writeIndex++] = (0xc0 or (itAsInt shr 6)).toByte()
//                utf8[writeIndex++] = (0x80 or (itAsInt and 0x3f)).toByte()
//            }
//            it in '\ud800' .. '\uE000' -> {
//                utf8[writeIndex++] = (0xe0 or (itAsInt shr 12)).toByte()
//                utf8[writeIndex++] = (0x80 or (itAsInt shr 6 and 0x3f)).toByte()
//                utf8[writeIndex++] = (0x80 or (itAsInt and 0x3f)).toByte()
//            }
//            else -> {
//
//                // UTF-16 encodes 0x10000-0x10FFFF by
//                // subtracting 0x10000 and splitting the
//                // 20 bits of 0x0-0xFFFFF into two halves
//                readIndex++
//                val charcode = 0x10000 + (((itAsInt and 0x3ff) shl 10) or (str[readIndex].toInt() and 0x3ff))
//
//                utf8[writeIndex++] = (0xf0 or (charcode shr 18)).toByte()
//                utf8[writeIndex++] = (0x80 or (itAsInt shr 12 and 0x3f)).toByte()
//                utf8[writeIndex++] = (0x80 or (itAsInt shr 6 and 0x3f)).toByte()
//                utf8[writeIndex++] = (0x80 or (itAsInt and 0x3f)).toByte()
//            }
//        }
//        readIndex++
//    }
//    return utf8
//}
