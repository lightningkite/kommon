package com.lightningkite.kommon.bytes

import com.lightningkite.kommon.bytes.hexToByteArray
import com.lightningkite.kommon.bytes.toStringHex
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue


class MainTest {

    @Test
    fun testHexConversion() {
        val source = byteArrayOf(0x1A, 0x2B, 0x3C, 0xFF.toByte())
        val expectedHex = "1A2B3CFF"
        assertEquals(expectedHex, source.toStringHex())
        assertTrue(source.contentEquals(source.toStringHex().hexToByteArray()))
    }

    @Test
    fun testBitArray() {
        //Sometimes people use integers to efficiently store a set of booleans.
        //You can use IntBitArray for this!
        val flags = IntBitArray(0)
        flags[0] = true //Index is number of bits from the right-most bit
        flags[1] = false
        flags[2] = true

        //Using binary, we can determine that the integer value is 5.  Let's see if it works.
        assertEquals(5, flags.value)

        //Let's look at an existing set of complicated flags.
        flags.value = 0x34721823 //In binary: 0000 0000 ... 0011 0100 0111 0010 0001 1000 0010 0011

        //Let's print out each bit - note this will be reversed of the binary representation.
        println(flags.joinToString("") { if (it) "1" else "0" })

        //Looks like #5 should be on.
        assertEquals(true, flags[5])

        //Looks like #2 should be off.
        assertEquals(false, flags[2])

        //Let's turn #2 on.
        flags[2] = true
        //The value should be ... 1100 0010 0011
        assertEquals(0x34721827, flags.value)
    }

    @Test
    fun utf8(){
        val string = "Test string with stuff"
        val raw = string.toUTF8ByteArray()
        val rewritten = String.fromUTF8ByteArray(raw)
        assertEquals(string, rewritten)
    }

    @Test
    fun utf16(){
        val string = "Test string with stuff"
        val raw = string.toUTF16ByteArray()
        val rewritten = String.fromUTF16ByteArray(raw)
        assertEquals(string, rewritten)
    }
}