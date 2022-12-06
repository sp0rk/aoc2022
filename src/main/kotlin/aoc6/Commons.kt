package aoc6

fun findSequenceStart(input: String, startSequenceSize: Int): Int {
    val deque = ArrayDeque<Char>(startSequenceSize)

    input.forEachIndexed { index, marker ->
        // push new marker
        deque.addLast(marker)

        if (deque.isStartSequence(startSequenceSize)) {
            return index + 1
        }

        // constraint deque to proper size
        if (deque.size >= startSequenceSize) {
            deque.removeFirst()
        }
    }

    throw IllegalArgumentException("Start sequence not present")
}

/**
 * Correct size and each element different from others
 */
private fun ArrayDeque<*>.isStartSequence(startSequenceSize: Int) = size == startSequenceSize && distinct() == this
