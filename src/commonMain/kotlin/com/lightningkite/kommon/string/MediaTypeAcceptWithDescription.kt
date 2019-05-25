package com.lightningkite.kommon.string

interface MediaTypeAcceptWithDescription {
    val mediaTypeAccept: MediaTypeAccept
    val description: String
    val extensions: List<String>

    companion object {
        val any = MediaTypeAcceptorWithDescription(MediaTypeAcceptor("*/*"), "Any", listOf("*"))
        val image = MediaTypeAcceptorWithDescription(MediaTypeAcceptor("image/*"), "Image", listOf("jpeg", "jpg", "png", "bmp", "tiff", "gif", "svg"))
    }
}

fun MediaTypeAcceptWithDescription(
        mediaTypeAccept: MediaTypeAccept,
        description: String,
        extensions: List<String>
) = MediaTypeAcceptorWithDescription(mediaTypeAccept, description, extensions)

data class MediaTypeAcceptorWithDescription(
        override val mediaTypeAccept: MediaTypeAccept,
        override val description: String,
        override val extensions: List<String>
): MediaTypeAcceptWithDescription