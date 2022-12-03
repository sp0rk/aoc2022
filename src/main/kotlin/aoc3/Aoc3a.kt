package aoc3

import core.Aoc
import core.Input

/***
 * Day 1: Rucksack Reorganization
 * https://adventofcode.com/2022/day/3
 *
 * Each rucksack has two large compartments. All items of a given type are meant to go into exactly one of the two
 * compartments. The Elf that did the packing failed to follow this rule for exactly one item type per rucksack.
 *
 * The Elves have made a list of all of the items currently in each rucksack (your puzzle input), but they need
 * your help finding the errors. Every item type is identified by a single lowercase or uppercase letter.
 *
 * The list of items for each rucksack is given as characters all on a single line. A given rucksack always has the same
 * number of items in each of its two compartments, so the first half of the characters represent items in the first
 * compartment, while the second half of the characters represent items in the second compartment.
 *
 * Lowercase item types a through z have priorities 1 through 26.
 * Uppercase item types A through Z have priorities 27 through 52.
 * Find the item type that appears in both compartments of each rucksack.
 * What is the sum of the priorities of those item types?
 */
object Aoc3a : Aoc {
    override val inputPath = "/inputs/Aoc3.txt"

    override fun calculateAnswer(input: Input): String {
        val rucksacks = input.lineStrings
        val totalItemPriority = rucksacks
            .map(::findItemInBothCompartments)
            .map(::calculateItemPriority)
            .sum()

        return "$totalItemPriority"
    }

    private fun findItemInBothCompartments(rucksack: String): Char {
        val compartmentSize = rucksack.length / 2
        val (firstCompartment, secondCompartment) = rucksack.chunked(compartmentSize, CharSequence::toSet)
        val commonItems = firstCompartment.intersect(secondCompartment)

        return commonItems.first()
    }

    private fun calculateItemPriority(item: Char): Int {
        val offsetFromA = item.lowercaseChar().code - LOWERCASE_A_CODE // B=1
        val lowercasePriority = offsetFromA + 1 // B=2
        val caseOffset = if (item.isUpperCase()) { // B=26
            UPPERCASE_OFFSET
        } else {
            0
        }

        return lowercasePriority + caseOffset // B=28
    }
}

private const val LOWERCASE_A_CODE = 97
private const val UPPERCASE_OFFSET = 26
