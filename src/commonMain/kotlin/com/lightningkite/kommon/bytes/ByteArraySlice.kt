package com.lightningkite.kommon.bytes

data class ByteArraySlice(var byteArray: ByteArray, var start: Int, var end: Int) : List<Byte> {
    override val size: Int get() = end - start
    override fun contains(element: Byte): Boolean = any { it == element }
    override fun containsAll(elements: Collection<Byte>): Boolean = elements.all { contains(it) }
    override fun indexOf(element: Byte): Int = indexOfFirst { it == element }
    override fun isEmpty(): Boolean = end - start > 0
    override fun lastIndexOf(element: Byte): Int = indexOfLast { it == element }
    override fun listIterator(): ListIterator<Byte> = listIterator(0)
    override fun listIterator(index: Int): ListIterator<Byte> = object : ListIterator<Byte> {
        var currentIndex = start + index
        override fun hasNext(): Boolean = currentIndex < end
        override fun hasPrevious(): Boolean = currentIndex > start
        override fun next(): Byte = byteArray[currentIndex++]
        override fun nextIndex(): Int = currentIndex
        override fun previous(): Byte = byteArray[--currentIndex]
        override fun previousIndex(): Int = currentIndex - 1
    }

    override fun subList(fromIndex: Int, toIndex: Int): List<Byte> = ByteArraySlice(byteArray, start + fromIndex, start + toIndex)

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false

        other as ByteArraySlice

        if (!byteArray.contentEquals(other.byteArray)) return false
        if (start != other.start) return false
        if (end != other.end) return false

        return true
    }

    override fun hashCode(): Int {
        var result = byteArray.contentHashCode()
        result = 31 * result + start
        result = 31 * result + end
        return result
    }

    override operator fun get(index: Int): Byte {
        if (index < 0 || index > end - start) throw IndexOutOfBoundsException()
        return byteArray[index + start]
    }

    operator fun set(index: Int, value: Byte) {
        if (index < 0 || index > end - start) throw IndexOutOfBoundsException()
        byteArray[index + start] = value
    }

    override operator fun iterator(): ByteIterator = object : ByteIterator() {
        var currentIndex = start

        override fun hasNext(): Boolean = currentIndex < end

        override fun nextByte(): Byte = byteArray[currentIndex++]
    }
}

fun ByteArray.subList(start: Int, end: Int) = ByteArraySlice(this, start, end)
fun ByteArray.subList(range: ClosedRange<Int>) = ByteArraySlice(this, range.start, range.endInclusive + 1)