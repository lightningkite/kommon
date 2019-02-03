package com.lightningkite.kommon.collection

actual class SortedSet<E> actual constructor(val comparator: Comparator<in E>) : MutableSet<E> {

    val underlying = ArrayList<E>()

    override fun add(element: E): Boolean{
        underlying.addSorted(element, comparator)
        return true
    }

    override fun addAll(elements: Collection<E>): Boolean{
        elements.forEach { add(it) }
        return true
    }

    override fun clear() = underlying.clear()

    override fun iterator(): MutableIterator<E> = underlying.iterator()

    override fun remove(element: E): Boolean = underlying.remove(element)

    override fun removeAll(elements: Collection<E>): Boolean = underlying.removeAll(elements)

    override fun retainAll(elements: Collection<E>): Boolean = underlying.retainAll(elements)

    override val size: Int get() = underlying.size

    override fun contains(element: E): Boolean = underlying.contains(element)

    override fun containsAll(elements: Collection<E>): Boolean = underlying.containsAll(elements)

    override fun isEmpty(): Boolean = underlying.isEmpty()
}