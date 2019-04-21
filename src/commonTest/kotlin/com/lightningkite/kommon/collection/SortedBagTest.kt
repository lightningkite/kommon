package com.lightningkite.kommon.collection

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class SortedBagTest {
    @Test fun test(){
        val bag = SortedSetNatural<Int>()
        println("Bag: ${bag.joinToString()}")
        bag.add(5)
        println("Bag: ${bag.joinToString()}")
        bag.add(3)
        println("Bag: ${bag.joinToString()}")
        bag.add(4)
        println("Bag: ${bag.joinToString()}")
        bag.add(1)
        println("Bag: ${bag.joinToString()}")
        bag.add(2)
        println("Bag: ${bag.joinToString()}")
        assertTrue { bag.size == 5 }
    }
}