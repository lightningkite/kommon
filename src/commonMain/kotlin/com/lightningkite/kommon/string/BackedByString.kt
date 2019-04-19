package com.lightningkite.kommon.string

interface BackedByString {
    val isValid: Boolean get() = true
    val string: String
}