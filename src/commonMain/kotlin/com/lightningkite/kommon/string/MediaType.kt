package com.lightningkite.kommon.string

inline class MediaType(override val string: String) : BackedByString, MediaTypeAccept {
    override val type: String get() = string.substringBefore('/')
    override val subtype: String get() = string.substringAfter('/').substringBefore(';')
    val parameters: List<Pair<String, String>>
        get() = string.substringAfter(';').split(';').mapNotNull {
            if (it.isEmpty()) return@mapNotNull null
            val parts = it.split(',')
            when (parts.size) {
                0 -> null
                1 -> parts[0] to ""
                else -> parts[0] to parts[1]
            }
        }

    constructor(type: String, subtype: String, parameters: List<Pair<String, String>>):this("$type/$subtype;${parameters.joinToString(";"){"${it.first}=${it.second}"}}")

    override val isValid: Boolean
        get() = string.count { it == '/' } == 1 && string.substringBefore(';').none { it.isWhitespace() || it.isControl() || it == '*' }
}



