package aoc4

import aoc4.Commons.parseRange
import core.Aoc
import core.Input

/***
 * Day 4: Camp Cleanup Part Two
 * https://adventofcode.com/2022/day/4
 *
 * The Elves would like to know the number of pairs that overlap at all.
 *
 * In how many assignment pairs do the ranges overlap?
 */
object Aoc4b : Aoc {
    override val inputPath = "/inputs/Aoc4.txt"

    override fun calculateAnswer(input: Input): String {
        val pairsWithPartialOverlaps = input.lineStrings.map { pair ->
            pair.split(",").map(::parseRange)
        }.count { (firstRange, secondRange) ->
            oneOverlapsTheOther(firstRange to secondRange)
        }

        return "$pairsWithPartialOverlaps"
    }

    private fun oneOverlapsTheOther(ranges: Pair<IntRange, IntRange>) =
        ranges.first overlaps ranges.second || ranges.second overlaps ranges.first

    private infix fun IntRange.overlaps(other: IntRange) =
        other.first in this || other.last in this
}
