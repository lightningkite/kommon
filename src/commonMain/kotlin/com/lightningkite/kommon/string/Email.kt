package com.lightningkite.kommon.string

inline class Email(override val string: String) : BackedByString {
    val name: String get() = string.substringBefore('@', "").substringBefore('+', "")
    val extension: String? get() = string.substringAfter('+', "").substringBefore('@', "").takeUnless { it.isEmpty() }
    val domain: String get() = string.substringAfter('@', "")
    override val isValid: Boolean get() = string.isEmail()

    fun copy(
            name: String = this.name,
            extension: String? = this.extension,
            domain: String = this.domain
    ) = Email(name, extension, domain)

    constructor(
            name: String,
            extension: String? = null,
            domain: String
    ) : this(
            if (extension != null) {
                "$name+$extension@$domain"
            } else {
                "$name@$domain"
            }
    )
    override fun toString(): String = string
}