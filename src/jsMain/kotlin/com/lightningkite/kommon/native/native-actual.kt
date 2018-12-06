package com.lightningkite.kommon.native

actual annotation class ThreadLocal()
actual annotation class SharedImmutable()
actual fun <T: Any> T.freeze(): T = this
actual fun Any.ensureNeverFrozen() = Unit
actual val Any.isFrozen: Boolean get() = false
