package com.lightningkite.kommon.bytes

import kotlin.random.Random
import kotlin.test.Test
import kotlin.test.assertEquals

class Base64Test {

    fun roundTrip(bytes: ByteArray, base64: String) {
        assertEquals(bytes.contentToString(), base64.decodeBase64().contentToString())
        assertEquals(base64, bytes.encodeBase64())
    }

    @Test fun wikipediaTest(){
        val man = byteArrayOf(
                0x4d,
                0x61,
                0x6e
        )
        roundTrip(man, "TWFu")
        roundTrip(man.sliceArray(0 .. 1), "TWE=")
        roundTrip(man.sliceArray(0 .. 0), "TQ==")
        assertEquals(man.sliceArray(0 .. 1).contentToString(), "TWE".decodeBase64().contentToString())
        assertEquals(man.sliceArray(0 .. 0).contentToString(), "TQ".decodeBase64().contentToString())
    }

    @Test fun chaosTest(){
        val data = Random.Default.nextBytes(40)
        roundTrip(data, data.encodeBase64())
    }
}