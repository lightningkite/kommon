package com.lightningkite.kommon.atomic

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class AtomicsTest {

    class FakeImpl<T>(var value: T) {
        fun compareAndSet(expected: T, new: T): Boolean {
            if(value == expected){
                value = new
                return true
            } else {
                return false
            }
        }
    }

    @Test
    fun ref() {
        val firstValue = "asdf"
        val newValue = "asdfg"
        val atomic = AtomicReference(firstValue)
        assertEquals(firstValue, atomic.value)
        assertFalse(atomic.compareAndSet(newValue, newValue))
        assertEquals(firstValue, atomic.value)
        assertTrue(atomic.compareAndSet(firstValue, newValue))
        assertEquals(newValue, atomic.value)
    }

    @Test
    fun integer() {
        val atomic = AtomicInt(3)
        assertEquals<Int>(3, atomic.value)
        assertEquals<Int>(4, atomic.addAndGet(1))
        assertEquals<Int>(4, atomic.value)
        assertFalse(atomic.compareAndSet(88, 5))
        assertEquals<Int>(4, atomic.value)
        assertTrue(atomic.compareAndSet(4, 5))
        assertEquals<Int>(5, atomic.value)
    }

    @Test
    fun value() {
        val atomic = AtomicValue(42)
        assertEquals<Int>(42, atomic.value)
        assertFalse(atomic.compareAndSet(88, 5))
        assertEquals<Int>(42, atomic.value)
        assertTrue(atomic.compareAndSet(42, 5))
        assertEquals<Int>(5, atomic.value)
    }

    @Test
    fun long() {
        val atomic = AtomicLong(3L)
        assertEquals<Long>(3L, atomic.value)
        assertEquals<Long>(4L, atomic.addAndGet(1))
        assertEquals<Long>(4L, atomic.value)
        assertFalse(atomic.compareAndSet(88L, 5L))
        assertEquals<Long>(4L, atomic.value)
        assertTrue(atomic.compareAndSet(4L, 5L))
        assertEquals<Long>(5L, atomic.value)
    }
}
