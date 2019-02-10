package com.lightningkite.kommon.collection

fun WeakHashMap<*, *>.clean() {
    this.size //Forces JVM and native to clean
}
