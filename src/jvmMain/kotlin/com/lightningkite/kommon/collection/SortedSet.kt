package com.lightningkite.kommon.collection

import java.util.*

actual typealias SortedSet<E> = TreeSet<E>

actual fun <E : Comparable<E>> SortedSetNatural(): MutableSet<E> = SortedSet(Comparator { a, b -> a.compareTo(b) })