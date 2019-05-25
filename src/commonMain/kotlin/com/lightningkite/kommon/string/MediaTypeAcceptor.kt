package com.lightningkite.kommon.string

interface MediaTypeAccept {
    val string: String
    val type: String
    val subtype: String
}

fun MediaTypeAccept(string: String) = MediaTypeAcceptor(string)
fun MediaTypeAccept(type: String, subtype: String) = MediaTypeAcceptor(type, subtype)

inline class MediaTypeAcceptor(override val string: String) : BackedByString, MediaTypeAccept {
    override val type: String get() = string.substringBefore('/')
    override val subtype: String get() = string.substringAfter('/').substringBefore(';')

    constructor(type: String, subtype: String) : this("$type/$subtype")

    override val isValid: Boolean
        get() = string.count { it == '/' } == 1 && string.none { it.isWhitespace() || it.isControl() }
}