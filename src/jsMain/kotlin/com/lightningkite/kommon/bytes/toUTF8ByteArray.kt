package com.lightningkite.kommon.bytes

external fun decodeURIComponent(encodedURI: String): String
external fun encodeURIComponent(unencodedURI: String): String
external fun escape(string: String): String
external fun unescape(string: String): String

//TODO: Check these.  They probably don't work.

actual fun String.toUTF8ByteArray(): ByteArray = unescape(encodeURIComponent(this)).toUTF16ByteArray()
actual fun String.Companion.fromUTF8ByteArray(byteArray: ByteArray): String = escape(decodeURIComponent(String.fromUTF16ByteArray(byteArray)))

actual fun String.toUTF16ByteArray(): ByteArray {
    val array = ByteArray(this.length * 2)
    var writeIndex = 0
    for(c in this){
        array[writeIndex++] = (c.toInt() shr 8).toByte()
        array[writeIndex++] = (c.toInt() and 0xFF).toByte()
    }
    return array
}
actual fun String.Companion.fromUTF16ByteArray(byteArray: ByteArray): String = js("String.fromCharCode.apply(String, byteArray)").unsafeCast<String>()
