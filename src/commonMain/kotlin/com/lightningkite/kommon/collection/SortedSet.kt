package com.lightningkite.kommon.collection

expect class SortedSet<E>(comparator: Comparator<in E>) : MutableSet<E> {}

expect fun <E : Comparable<E>> SortedSetNatural(): MutableSet<E>// = SortedSet(Comparator { a, b -> a.compareTo(b) })