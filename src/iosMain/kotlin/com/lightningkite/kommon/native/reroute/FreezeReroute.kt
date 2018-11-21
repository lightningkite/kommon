package com.lightningkite.kommon.native.reroute

import kotlin.native.concurrent.isFrozen

fun Any.rerouteFrozen(): Boolean = this.isFrozen