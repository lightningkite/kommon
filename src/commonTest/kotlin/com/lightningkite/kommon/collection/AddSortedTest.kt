package com.lightningkite.kommon.collection

import kotlin.test.Test
import kotlin.test.assertEquals

class AddSortedTest {
    @Test fun test(){
        val list = arrayListOf(4, 7, 12)
        val insertedPosition = list.addSorted(10)
        assertEquals(2, insertedPosition)
    }
}