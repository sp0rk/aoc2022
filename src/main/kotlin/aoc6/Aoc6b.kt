package aoc6

import core.Aoc
import core.Input

/**
 * Day 6: Tuning Trouble Part Two
 * https://adventofcode.com/2022/day/6
 *
 * A start-of-message marker is just like a start-of-packet marker, except it consists of 14 distinct characters
 * rather than 4.
 *
 * How many characters need to be processed before the first start-of-message marker is detected?
 */
object Aoc6b : Aoc {
    private const val START_SEQUENCE_SIZE = 14
    override val inputPath = "/inputs/Aoc6.txt"

    override fun calculateAnswer(input: Input) = findSequenceStart(input.raw, START_SEQUENCE_SIZE).toString()
}
