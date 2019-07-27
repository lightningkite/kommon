package com.lightningkite.kommon.string

data class MediaTypeWithDescription(
        val mediaType: MediaType,
        override val description: String,
        override val extensions: List<String>
): MediaTypeAcceptWithDescription {
    override val mediaTypeAccept: MediaTypeAccept
        get() = mediaType
    companion object {
        val aac = MediaTypeWithDescription(MediaType("audio/aac"), "AAC audio", listOf("aac"))
        val abw = MediaTypeWithDescription(MediaType("application/x-abiword"), "AbiWord document", listOf("abw"))
        val arc = MediaTypeWithDescription(MediaType("application/x-freearc"), "Archive document (multiple files embedded)", listOf("arc"))
        val avi = MediaTypeWithDescription(MediaType("video/x-msvideo"), "AVI: Audio Video Interleave", listOf("avi"))
        val azw = MediaTypeWithDescription(MediaType("application/vnd.amazon.ebook"), "Amazon Kindle eBook format", listOf("azw"))
        val bin = MediaTypeWithDescription(MediaType("application/octet-stream"), "Any kind of binary data", listOf("bin"))
        val bmp = MediaTypeWithDescription(MediaType("image/bmp"), "Windows OS/2 Bitmap Graphics", listOf("bmp"))
        val bz = MediaTypeWithDescription(MediaType("application/x-bzip"), "BZip archive", listOf("bz"))
        val bz2 = MediaTypeWithDescription(MediaType("application/x-bzip2"), "BZip2 archive", listOf("bz2"))
        val csh = MediaTypeWithDescription(MediaType("application/x-csh"), "C-Shell script", listOf("csh"))
        val css = MediaTypeWithDescription(MediaType("text/css"), "Cascading Style Sheets (CSS)", listOf("css"))
        val csv = MediaTypeWithDescription(MediaType("text/csv"), "Comma-separated values (CSV)", listOf("csv"))
        val doc = MediaTypeWithDescription(MediaType("application/msword"), "Microsoft Word", listOf("doc"))
        val docx = MediaTypeWithDescription(MediaType("application/vnd.openxmlformats-officedocument.wordprocessingml.document"), "Microsoft Word (OpenXML)", listOf("docx"))
        val eot = MediaTypeWithDescription(MediaType("application/vnd.ms-fontobject"), "MS Embedded OpenType fonts", listOf("eot"))
        val epub = MediaTypeWithDescription(MediaType("application/epub+zip"), "Electronic publication (EPUB)", listOf("epub"))
        val gif = MediaTypeWithDescription(MediaType("image/gif"), "Graphics Interchange Format (GIF)", listOf("gif"))
        val html = MediaTypeWithDescription(MediaType("text/html"), "HyperText Markup Language (HTML)", listOf("htm", "html"))
        val ico = MediaTypeWithDescription(MediaType("image/vnd.microsoft.icon"), "Icon format", listOf("ico"))
        val ics = MediaTypeWithDescription(MediaType("text/calendar"), "iCalendar format", listOf("ics"))
        val jar = MediaTypeWithDescription(MediaType("application/java-archive"), "Java Archive (JAR)", listOf("jar"))
        val jpg = MediaTypeWithDescription(MediaType("image/jpeg"), "JPEG images", listOf("jpg", "jpeg"))
        val js = MediaTypeWithDescription(MediaType("text/javascript"), "JavaScript", listOf("js"))
        val json = MediaTypeWithDescription(MediaType("application/json"), "JSON format", listOf("json"))
        val jsonld = MediaTypeWithDescription(MediaType("application/ld+json"), "JSON-LD format", listOf("jsonld"))
        val mid = MediaTypeWithDescription(MediaType("audio/midi audio/x-midi"), "Musical Instrument Digital Interface (MIDI)", listOf("mid"))
        val mjs = MediaTypeWithDescription(MediaType("text/javascript"), "JavaScript module", listOf("mjs"))
        val mp3 = MediaTypeWithDescription(MediaType("audio/mpeg"), "MP3 audio", listOf("mp3"))
        val mpeg = MediaTypeWithDescription(MediaType("video/mpeg"), "MPEG Video", listOf("mpeg"))
        val mpkg = MediaTypeWithDescription(MediaType("application/vnd.apple.installer+xml"), "Apple Installer Package", listOf("mpkg"))
        val odp = MediaTypeWithDescription(MediaType("application/vnd.oasis.opendocument.presentation"), "OpenDocument presentation document", listOf("odp"))
        val ods = MediaTypeWithDescription(MediaType("application/vnd.oasis.opendocument.spreadsheet"), "OpenDocument spreadsheet document", listOf("ods"))
        val odt = MediaTypeWithDescription(MediaType("application/vnd.oasis.opendocument.text"), "OpenDocument text document", listOf("odt"))
        val oga = MediaTypeWithDescription(MediaType("audio/ogg"), "OGG audio", listOf("oga"))
        val ogv = MediaTypeWithDescription(MediaType("video/ogg"), "OGG video", listOf("ogv"))
        val ogx = MediaTypeWithDescription(MediaType("application/ogg"), "OGG", listOf("ogx"))
        val otf = MediaTypeWithDescription(MediaType("font/otf"), "OpenType font", listOf("otf"))
        val png = MediaTypeWithDescription(MediaType("image/png"), "Portable Network Graphics", listOf("png"))
        val pdf = MediaTypeWithDescription(MediaType("application/pdf"), "Adobe Portable Document Format (PDF)", listOf("pdf"))
        val ppt = MediaTypeWithDescription(MediaType("application/vnd.ms-powerpoint"), "Microsoft PowerPoint", listOf("ppt"))
        val pptx = MediaTypeWithDescription(MediaType("application/vnd.openxmlformats-officedocument.presentationml.presentation"), "Microsoft PowerPoint (OpenXML)", listOf("pptx"))
        val rar = MediaTypeWithDescription(MediaType("application/x-rar-compressed"), "RAR archive", listOf("rar"))
        val rtf = MediaTypeWithDescription(MediaType("application/rtf"), "Rich Text Format (RTF)", listOf("rtf"))
        val sh = MediaTypeWithDescription(MediaType("application/x-sh"), "Bourne shell script", listOf("sh"))
        val svg = MediaTypeWithDescription(MediaType("image/svg+xml"), "Scalable Vector Graphics (SVG)", listOf("svg"))
        val swf = MediaTypeWithDescription(MediaType("application/x-shockwave-flash"), "Small web format (SWF) or Adobe Flash document", listOf("swf"))
        val tar = MediaTypeWithDescription(MediaType("application/x-tar"), "Tape Archive (TAR)", listOf("tar"))
        val tiff = MediaTypeWithDescription(MediaType("image/tiff"), "Tagged Image File Format (TIFF)", listOf("tif", "tiff"))
        val ttf = MediaTypeWithDescription(MediaType("font/ttf"), "TrueType Font", listOf("ttf"))
        val txt = MediaTypeWithDescription(MediaType("text/plain"), "Text, (generally ASCII or ISO 8859-n)", listOf("txt"))
        val vsd = MediaTypeWithDescription(MediaType("application/vnd.visio"), "Microsoft Visio", listOf("vsd"))
        val wav = MediaTypeWithDescription(MediaType("audio/wav"), "Waveform Audio Format", listOf("wav"))
        val weba = MediaTypeWithDescription(MediaType("audio/webm"), "WEBM audio", listOf("weba"))
        val webm = MediaTypeWithDescription(MediaType("video/webm"), "WEBM video", listOf("webm"))
        val webp = MediaTypeWithDescription(MediaType("image/webp"), "WEBP image", listOf("webp"))
        val woff = MediaTypeWithDescription(MediaType("font/woff"), "Web Open Font Format (WOFF)", listOf("woff"))
        val woff2 = MediaTypeWithDescription(MediaType("font/woff2"), "Web Open Font Format (WOFF)", listOf("woff2"))
        val xhtml = MediaTypeWithDescription(MediaType("application/xhtml+xml"), "XHTML", listOf("xhtml"))
        val xls = MediaTypeWithDescription(MediaType("application/vnd.ms-excel"), "Microsoft Excel", listOf("xls"))
        val xlsx = MediaTypeWithDescription(MediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"), "Microsoft Excel (OpenXML)", listOf("xlsx"))
        val xml = MediaTypeWithDescription(MediaType("application/xml"), "XML", listOf("xml"))
        val xul = MediaTypeWithDescription(MediaType("application/vnd.mozilla.xul+xml"), "XUL", listOf("xul"))
        val zip = MediaTypeWithDescription(MediaType("application/zip"), "ZIP archive", listOf("zip"))
        val _3gpVideo = MediaTypeWithDescription(MediaType("video/3gpp"), "3GPP video container", listOf("3gp"))
        val _3g2Video = MediaTypeWithDescription(MediaType("video/3gpp2"), "3GPP2 video container", listOf("3g2"))
        val _3gpAudio = MediaTypeWithDescription(MediaType("audio/3gpp"), "3GPP audio container", listOf("3gp"))
        val _3g2Audio = MediaTypeWithDescription(MediaType("audio/3gpp2"), "3GPP2 audio container", listOf("3g2"))
        val _7z = MediaTypeWithDescription(MediaType("application/x-7z-compressed"), "7-zip archive", listOf("7z"))
        val cbor = MediaTypeWithDescription(MediaType("application/cbor"), "CBOR format", listOf("cbor"))
        val protobuf = MediaTypeWithDescription(MediaType("application/protobuf"), "Protobuf format", listOf("proto"))
    }
}