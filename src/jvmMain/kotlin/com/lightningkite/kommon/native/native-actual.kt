package com.lightningkite.kommon.native

actual annotation class ThreadLocal()
actual annotation class SharedImmutable()
actual fun Any.freeze() = Unit
actual fun Any.ensureNeverFrozen() = Unit
actual val Any.isFrozen: Boolean get() = false