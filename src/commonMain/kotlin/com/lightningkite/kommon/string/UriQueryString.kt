package com.lightningkite.kommon.string

inline class UriQueryString(override val string: String) : BackedByString {
    constructor(params: Iterable<Pair<String, String>>) : this(params.joinToString {
        it.first.urlEscape() + "=" + it.second.urlEscape()
    })

    val parameters: Sequence<Pair<String, String>>
        get() = string.splitToSequence('&')
                .map { it.substringBefore('=').urlUnescape() to it.substringAfter('=', "").urlUnescape() }

    val escapedParameters: Sequence<Pair<String, String>>
        get() = string.splitToSequence('&')
                .map { it.substringBefore('=') to it.substringAfter('=', "") }
    override fun toString(): String = string
}