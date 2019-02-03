package com.lightningkite.kommon.collection

import kotlin.native.ref.WeakReference

//TODO: Need actual implementation

actual class WeakHashMap<K: Any, V> actual constructor(): MutableMap<K, V> by HashMap()