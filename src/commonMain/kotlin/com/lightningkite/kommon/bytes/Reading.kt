package com.lightningkite.kommon.bytes

interface ByteReadable {
    suspend fun read(actions: suspend MidRead.() -> Unit)
    interface MidRead {
        suspend fun read(chunk: ByteArray): Int
        fun readAvailable(chunk: ByteArray): Int
        suspend fun skip(bytes: Long)
    }
}

suspend fun ByteReadable.read(chunk: ByteArray = ByteArray(4096), onChunk: suspend (ByteArraySlice) -> Unit) {
    read {
        val slice = ByteArraySlice(chunk, 0, chunk.size)
        while(true){
            val read = read(chunk)
            if(read == -1) break
            slice.end = read
            onChunk(slice)
        }
    }
}