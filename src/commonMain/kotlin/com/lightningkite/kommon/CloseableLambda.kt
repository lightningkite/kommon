package com.lightningkite.kommon

inline class CloseableLambda(val lambda: ()->Unit) : Closeable {
    override fun close() = lambda()
}