package com.lightningkite.kommon.native

expect annotation class ThreadLocal()
expect annotation class SharedImmutable()
expect fun <T: Any> T.freeze(): T
expect fun Any.ensureNeverFrozen()
expect val Any.isFrozen: Boolean
