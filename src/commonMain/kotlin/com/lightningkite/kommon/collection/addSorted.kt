package com.lightningkite.kommon.collection

/**
 * Finds the position an item belongs in the list (assuming it's sorted) according to [compare] and inserts it there.
 */
fun <E> MutableList<E>.addSorted(item: E, compare: (E, E) -> Boolean): Int {
    var index = 0
    for (it in this) {
        if (compare(item, it)) {
            break
        }
        index++
    }
    add(index, item)
    return index
}

/**
 * Finds the position an item belongs in the list (assuming it's sorted) according to [compare] and inserts it there.
 */
fun <E> MutableList<E>.addSorted(item: E, comparator: Comparator<in E>): Int {
    var index = 0
    for (it in this) {
        if (comparator.compare(item, it) < 0) {
            break
        }
        index++
    }
    add(index, item)
    return index
}

/**
 * Finds the position an item belongs in the list (assuming it's sorted) according to [compare] and inserts it there.
 */
fun <E : Comparable<E>> MutableList<E>.addSorted(item: E): Int {
    var index = 0
    for (it in this) {
        if (item.compareTo(it) < 0) {
            break
        }
        index++
    }
    add(index, item)
    return index
}

/**
 * Finds the position an item belongs in the list (assuming it's sorted) and inserts it there.
 */
fun <E : Comparable<E>> MutableList<E>.addAllSorted(items: Collection<E>) {
    for (item in items) {
        addSorted(item)
    }
}

/**
 * Finds the position an item belongs in the list (assuming it's sorted) and inserts it there.
 */
@Suppress("NOTHING_TO_INLINE")
inline fun <E : Comparable<E>> MutableList<E>.addSortedReverse(item: E): Int {
    var index = 0
    for (it in this) {
        if (item.compareTo(it) > 0) {
            break
        }
        index++
    }
    add(index, item)
    return index
}
