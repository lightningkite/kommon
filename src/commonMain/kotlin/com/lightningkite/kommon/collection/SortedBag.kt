package com.lightningkite.kommon.collection

class SortedBag<E>(
        comparator: Comparator<E>,
        val underlying: MutableList<E> = ArrayList()
) : MutableCollection<E> {

    val comparator = comparator.thenBy { it.hashCode() }

    override fun add(element: E): Boolean {
        val result = underlying.binarySearch(element, comparator)
        if (result < 0) {
            underlying.add(-(result + 1), element)
        } else {
            underlying.add(result, element)
        }
        return true
    }

    override fun addAll(elements: Collection<E>): Boolean {
        elements.forEach { add(it) }
        return true
    }

    override fun clear() = underlying.clear()

    override fun iterator(): MutableIterator<E> = underlying.iterator()

    fun indexOf(element: E): Int {
        val result = underlying.binarySearch(element, comparator)
        if (result >= 0) {
            var index = result
            while (true) {
                val atIndex = underlying[index]
                if (atIndex == element) {
                    return index
                }
                val comparisonResult = comparator.compare(element, underlying[index])
                if (comparisonResult == 0) {
                    index--
                } else {
                    break
                }
            }
            index = result + 1
            while (true) {
                val atIndex = underlying[index]
                if (atIndex == element) {
                    return index
                }
                val comparisonResult = comparator.compare(element, underlying[index])
                if (comparisonResult == 0) {
                    index++
                } else {
                    break
                }
            }
            return -1
        } else return -1
    }

    override fun remove(element: E): Boolean {
        val index = indexOf(element)
        if (index == -1) return false
        underlying.removeAt(index)
        return true
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

    override fun contains(element: E): Boolean = indexOf(element) != -1

    override fun containsAll(elements: Collection<E>): Boolean = underlying.all { indexOf(it) != -1 }

    override fun isEmpty(): Boolean = underlying.isEmpty()

    fun addAllOfSameSort(other: SortedBag<E>) {
        var thisIndex = 0
        var otherIndex = 0

        while (thisIndex < this.underlying.size && otherIndex < other.underlying.size) {
            val thisElement = this.underlying[thisIndex]
            val otherElement = other.underlying[otherIndex]
            if (comparator.compare(thisElement, otherElement) <= 0) {
                thisIndex++
            } else {
                underlying.add(thisIndex, otherElement)
                otherIndex++
            }
        }

        for (i in otherIndex..other.underlying.lastIndex) {
            underlying.add(other.underlying[i])
        }
    }

    fun copy(): SortedBag<E> = SortedBag(comparator, underlying.toMutableList())

    operator fun plus(other: SortedBag<E>): SortedBag<E> {
        return this.copy().apply { addAllOfSameSort(other) }
    }

    fun first() = underlying.first()
    fun last() = underlying.last()
    fun firstOrNull() = underlying.firstOrNull()
    fun lastOrNull() = underlying.lastOrNull()
    fun popLast() = if(underlying.isNotEmpty()) underlying.removeAt(underlying.lastIndex) else null
    fun popFirst() = if(underlying.isNotEmpty()) underlying.removeAt(0) else null
}

fun <E : Comparable<E>> SortedBag() = SortedBag<E>(Comparator { a, b -> a.compareTo(b) })