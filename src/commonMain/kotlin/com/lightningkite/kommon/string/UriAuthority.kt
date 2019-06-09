package com.lightningkite.kommon.string

inline class UriAuthority(override val string: String) : BackedByString {

    val userInfo: String? get() = string.substringBefore('@', "").takeUnless { it.isEmpty() }
    val host: String get() = string.substringAfter('@').substringBefore(':')
    val port: String? get() = string.substringAfter(':', "").takeUnless { it.isEmpty() }

    constructor(
            userInfo: String? = null,
            host: String,
            port: String? = null
    ) : this(buildString {
        if (userInfo != null) {
            append(userInfo)
            append('@')
        }
        append(host)
        if (port != null) {
            append(':')
            append(port)
        }
    })

    fun copy(
            userInfo: String? = this.userInfo,
            host: String = this.host,
            port: String? = this.port
    ): UriAuthority = UriAuthority(userInfo, host, port)
    override fun toString(): String = string
}