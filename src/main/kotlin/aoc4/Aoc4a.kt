package aoc4

import core.Aoc
import core.Input

/***
 * Day 4: Camp Cleanup
 * https://adventofcode.com/2022/day/3
 *
 * Every section has a unique ID number, and each Elf is assigned a range of section IDs.
 *
 * The Elves pair up and make a big list of the section assignments for each pair (your puzzle input).
 *
 * Some pairs have noticed that one of their assignments fully contains the other.
 * For example, 2-8 fully contains 3-7, and 6-6 is fully contained by 4-6.
 *
 * In how many assignment pairs does one range fully contain the other?
 */
object Aoc4a : Aoc {
    override val inputPath = "/inputs/Aoc4.txt"

    override fun calculateAnswer(input: Input): String {
        val pairsWithFullOverlaps = input.lineStrings.map { pair ->
            pair.split(",").map(::parseRange)
        }.count { (firstRange, secondRange) ->
            oneContainsTheOther(firstRange to secondRange)
        }

        return "$pairsWithFullOverlaps"
    }

    private fun parseRange(rangeString: String) = rangeString.split("-").let { (rangeStart, rangeEnd) ->
        IntRange(rangeStart.toInt(), rangeEnd.toInt())
    }

    private fun oneContainsTheOther(ranges: Pair<IntRange, IntRange>) =
        ranges.first in ranges.second || ranges.second in ranges.first

    private operator fun IntRange.contains(other: IntRange) =
        other.first in this && other.last in this
}
