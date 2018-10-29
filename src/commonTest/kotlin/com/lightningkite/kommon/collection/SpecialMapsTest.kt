package com.lightningkite.kommon.collection

import kotlin.test.Test
import kotlin.test.assertTrue

class SpecialMapsTest{
    @Test
    fun isNormalMap(){
        val keyA = "keyA"
        val maps = listOf(ConcurrentHashMap<String, Int>(), WeakHashMap<String, Int>())
        for(map in maps){
            map[keyA] = 0
            assertTrue { map[keyA] == 0 }
            map[keyA] = 1
            assertTrue { map[keyA] == 1 }
        }
    }
}