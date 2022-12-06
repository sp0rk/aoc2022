package aoc6

import core.Aoc
import core.Input

/**
 * Day 6: Tuning Trouble
 * https://adventofcode.com/2022/day/6#part2
 *
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

    override fun calculateAnswer(input: Input) = findSequenceStart(input.raw, START_SEQUENCE_SIZE).toString()
}
