package com.lightningkite.kommon.exception

actual fun Throwable.stackTraceString(): String {
    return generateSequence<Throwable>(this) { it.cause }.joinToString("\n") {
        it.toString() + ": " + it.message
    }
}