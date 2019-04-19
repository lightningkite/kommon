package com.lightningkite.kommon.string

inline class Uri(override val string: String) : BackedByString {

    override val isValid get() = scheme.isNotBlank() && path.isNotBlank()

    val scheme: String get() = string.substringBefore(':')
    val authority: UriAuthority? get() = string.substringAfter("://", "").substringBefore('/', "").takeUnless { it.isBlank() }?.let(::UriAuthority)
    val path: String get() = string.substringAfter(':', "").substringAfter("//").substringAfter("/", "")
    val query: UriQueryString? get() = string.substringAfter('?', "").substringBefore('#').takeUnless { it.isBlank() }?.let(::UriQueryString)
    val fragment: String? get() = string.substringAfter("#", "").takeUnless { it.isBlank() }

    constructor(
            scheme: String,
            authority: UriAuthority? = null,
            path: String,
            query: UriQueryString? = null,
            fragment: String? = null
    ) : this(buildString {
        append(scheme)
        append(":")
        if (authority != null) {
            append("//")
            append(authority.string)
            append("/")
        }
        append(path)
        if (query != null) {
            append('?')
            append(query.string)
        }
        if (fragment != null) {
            append('#')
            append(fragment)
        }
    })

    fun copy(
            scheme: String = this.scheme,
            authority: UriAuthority? = this.authority,
            path: String = this.path,
            query: UriQueryString? = this.query,
            fragment: String? = this.fragment
    ): Uri = Uri(
            scheme = scheme,
            authority = authority,
            path = path,
            query = query,
            fragment = fragment
    )
}