package com.lightningkite.kommon.bytes


object Base64 {
    val encodeTable = (CharRange('A', 'Z') + CharRange('a', 'z') + CharRange('0', '9') + '+' + '/').toCharArray()
    val decodeTable = (0..255).map { encodeTable.indexOf(it.toChar()) }.toIntArray()
    val encodeTableUrlSafe = (CharRange('A', 'Z') + CharRange('a', 'z') + CharRange('0', '9') + '-' + '_').toCharArray()
    val decodeTableUrlSafe = (0..255).map { encodeTableUrlSafe.indexOf(it.toChar()) }.toIntArray()
}

fun ByteArray.encodeBase64(table: CharArray = Base64.encodeTableUrlSafe): String {
    val output = StringBuilder()
    var padding = 0
    var position = 0
    while (position < this.size) {
        var b = this[position].toInt() and 0xFF shl 16 and 0xFFFFFF
        if (position + 1 < this.size) b = b or (this[position + 1].toInt() and 0xFF shl 8) else padding++
        if (position + 2 < this.size) b = b or (this[position + 2].toInt() and 0xFF) else padding++
        for (i in 0 until 4 - padding) {
            val c = b and 0xFC0000 shr 18
            output.append(table[c])
            b = b shl 6
        }
        position += 3
    }
    for (i in 0 until padding) {
        output.append('=')
    }
    return output.toString()
}

fun String.decodeBase64(table: IntArray = Base64.decodeTableUrlSafe): ByteArray {
    val output = ByteArray(when{
        this[length-2] == '=' -> (this.length - 2) * 3 / 4
        this[length-1] == '=' -> (this.length - 1) * 3 / 4
        else -> this.length * 3 / 4
    })
    var position = 0
    var byteArrayPosition = 0
    while (position < length) {
        var b: Int
        if (table[this[position].toInt()] != -1) {
            b = table[this[position].toInt()] and 0xFF shl 18
        } else {
            position++
            continue
        }
        var count = 0
        if (position + 1 < this.length && table[this[position + 1].toInt()] != -1) {
            b = b or (table[this[position + 1].toInt()] and 0xFF shl 12)
            count++
        }
        if (position + 2 < this.length && table[this[position + 2].toInt()] != -1) {
            b = b or (table[this[position + 2].toInt()] and 0xFF shl 6)
            count++
        }
        if (position + 3 < this.length && table[this[position + 3].toInt()] != -1) {
            b = b or (table[this[position + 3].toInt()] and 0xFF)
            count++
        }
        while (count > 0) {
            val c = b and 0xFF0000 shr 16
            output[byteArrayPosition++] = c.toByte()
            b = b shl 8
            count--
        }
        position += 4
    }
    return output
}