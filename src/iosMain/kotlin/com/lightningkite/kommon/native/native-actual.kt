package com.lightningkite.kommon.native

import com.lightningkite.kommon.native.reroute.rerouteFrozen

actual typealias ThreadLocal = kotlin.native.ThreadLocal
actual typealias SharedImmutable = kotlin.native.SharedImmutable
actual fun Any.freeze() = kotlin.native.concurrent.freeze()
actual fun Any.ensureNeverFrozen() = kotlin.native.concurrent.ensureNeverFrozen()
actual val Any.isFrozen: Boolean get() = rerouteFrozen()