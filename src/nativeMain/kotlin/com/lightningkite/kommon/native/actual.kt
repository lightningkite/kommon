package com.lightningkite.kommon.native

import com.lightningkite.kommon.native.reroute.rerouteEnsureNeverFrozen
import com.lightningkite.kommon.native.reroute.rerouteFreeze
import com.lightningkite.kommon.native.reroute.rerouteFrozen

actual fun <T: Any> T.freeze(): T = rerouteFreeze()
actual fun Any.ensureNeverFrozen() = rerouteEnsureNeverFrozen()
actual val Any.isFrozen: Boolean get() = rerouteFrozen()