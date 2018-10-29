package com.lightningkite.kommon.bytes

actual fun String.toUTF8ByteArray(): ByteArray = this.toByteArray(Charsets.UTF_8)
actual fun String.Companion.fromUTF8ByteArray(byteArray: ByteArray): String = String(byteArray, Charsets.UTF_8)

actual fun String.toUTF16ByteArray(): ByteArray = this.toByteArray(Charsets.UTF_16)
actual fun String.Companion.fromUTF16ByteArray(byteArray: ByteArray): String = String(byteArray, Charsets.UTF_16)
