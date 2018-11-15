package com.lightningkite.kommon.exception

/**
 * Used to indicate that the user does not have permission to do this action.
 */
class ForbiddenException(message: String? = null): Exception(message)
