package com.lightningkite.kommon.collection

actual class SortedSet<E> actual constructor(val comparator: Comparator<in E>) : MutableSet<E> {

    val underlying = ArrayList<E>()

    override fun add(element: E): Boolean {
        val result = underlying.binarySearch(element, comparator)
        return if (result < 0) {
            underlying.add(-(result + 1), element)
            true
        } else
            false
    }

    override fun addAll(elements: Collection<E>): Boolean {
        var allTrue = true
        elements.forEach {
            allTrue = allTrue && add(it)
        }
        return allTrue
    }

    override fun clear() = underlying.clear()

    override fun iterator(): MutableIterator<E> = underlying.iterator()

    override fun remove(element: E): Boolean {
        val result = underlying.binarySearch(element, comparator)
        return if (result >= 0) {
            underlying.removeAt(result)
            true
        } else {
            false
        }
    }

    override fun removeAll(elements: Collection<E>): Boolean {
        var allTrue = true
        elements.forEach {
            allTrue = allTrue && remove(it)
        }
        return allTrue
    }

    override fun retainAll(elements: Collection<E>): Boolean = underlying.retainAll(elements)

    override val size: Int get() = underlying.size

    override fun contains(element: E): Boolean = underlying.binarySearch(element, comparator) >= 0

    override fun containsAll(elements: Collection<E>): Boolean = underlying.all { underlying.binarySearch(it, comparator) >= 0 }

    override fun isEmpty(): Boolean = underlying.isEmpty()
}

actual fun <E : Comparable<E>> SortedSetNatural(): MutableSet<E> = SortedSet(Comparator { a, b -> a.compareTo(b) })