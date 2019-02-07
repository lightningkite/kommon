package com.lightningkite.kommon.collection

expect class WeakHashMap<K: Any, V>() : MutableMap<K, V>

fun WeakHashMap<*, *>.clean() {
    this.size //Forces JVM and native to clean
}
