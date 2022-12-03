package aoc3

import aoc3.Commons.calculateItemPriority
import core.Aoc
import core.Input

private const val GROUP_SIZE = 3

/***
 * Day 1: Rucksack Reorganization Part Two
 * https://adventofcode.com/2022/day/3
 *
 * The only way to tell which item type is the right one is by finding
 * the one item type that is common between all three Elves in each group.
 *
 * Every set of three lines in your list corresponds to a single group,
 * but each group can have a different badge item type.
 *
 * Priorities for these items must still be found to organize the sticker attachment efforts
 *
 * Find the item type that corresponds to the badges of each three-Elf group.
 * What is the sum of the priorities of those item types?
 */
object Aoc3b : Aoc {
    override val inputPath = "/inputs/Aoc3.txt"

    override fun calculateAnswer(input: Input): String {
        val rucksacks = input.lineStrings
        val groups = rucksacks.chunked(GROUP_SIZE)
        val badges = groups.map { group ->
            val groupRucksacks = group.map(CharSequence::toSet)

            findItemsInAllRucksacks(groupRucksacks).first()
        }

        val totalPriority = badges
            .map(::calculateItemPriority)
            .sum()

        return "$totalPriority"
    }

    private fun findItemsInAllRucksacks(groupRucksacks: List<Set<Char>>) =
        groupRucksacks.reduce { acc, rucksack ->
            acc.intersect(rucksack)
        }
}
