package com.lightningkite.kommon.native


actual fun <T: Any> T.freeze(): T = this
actual fun Any.ensureNeverFrozen() = Unit
actual val Any.isFrozen: Boolean get() = false