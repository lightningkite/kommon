package com.lightningkite.kommon.collection

expect class SortedSet<E>(comparator: Comparator<in E>): MutableSet<E>