package aoc6

import core.Aoc
import core.Input

/**
 * Day 6: Tuning Trouble
 * To fix the communication system, you need to add a subroutine to the device that detects a start-of-packet marker
 * in the data-stream. In the protocol being used by the Elves, the start of a packet is indicated by a sequence of
 * four characters that are all different.
 *
 * The device will send your subroutine a data-stream buffer (your puzzle input); your subroutine needs to identify the
 * first position where the four most recently received characters were all different.
 * Specifically, it needs to report the number of characters from the beginning of the buffer to the end of the first
 * such four-character marker.
 *
 * How many characters need to be processed before the first start-of-packet marker is detected?
 */
object Aoc6a : Aoc {
    private const val START_SEQUENCE_SIZE = 4
    override val inputPath = "/inputs/Aoc6.txt"

    override fun calculateAnswer(input: Input): String {
        val deque = ArrayDeque<Char>(START_SEQUENCE_SIZE)
        input.raw.forEachIndexed { index, marker ->
            // push new marker
            deque.addLast(marker)

            if (deque.isStartSequence) {
                return (index + 1).toString()
            }

            // constraint deque to proper size
            if (deque.size >= START_SEQUENCE_SIZE) {
                deque.removeFirst()
            }
        }

        throw IllegalArgumentException("Start sequence not present")
    }

    /**
     * Correct size and each element different from others
     */
    private val ArrayDeque<*>.isStartSequence
        get() = size == START_SEQUENCE_SIZE && distinct() == this
}
