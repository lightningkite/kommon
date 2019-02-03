package com.lightningkite.kommon.exception

actual fun Throwable.stackTraceString(): String {
    return this.getStackTrace().joinToString("\n")
}