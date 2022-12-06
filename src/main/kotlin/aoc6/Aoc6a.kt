package aoc6

import core.Aoc
import core.Input

/**
 * Day 6: Tuning Trouble ---
 * To fix the communication system, you need to add a subroutine to the device that detects a start-of-packet marker
 * in the data-stream. In the protocol being used by the Elves, the start of a packet is indicated by a sequence of
 * four characters that are all different.
 *
 * The device will send your subroutine a datastream buffer (your puzzle input); your subroutine needs to identify the
 * first position where the four most recently received characters were all different.
 * Specifically, it needs to report the number of characters from the beginning of the buffer to the end of the first
 * such four-character marker.
 *
 * How many characters need to be processed before the first start-of-packet marker is detected?
 */
object Aoc6a : Aoc {
    override val inputPath = "/inputs/Aoc6.txt"

    override fun calculateAnswer(input: Input): String {
        return "not implemented"
    }
}
