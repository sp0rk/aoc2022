package aoc4

object Commons {
    fun parseRange(rangeString: String) = rangeString.split("-").let { (rangeStart, rangeEnd) ->
        IntRange(rangeStart.toInt(), rangeEnd.toInt())
    }
}
