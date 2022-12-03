package aoc3

import core.Aoc
import core.Input

private const val LOWERCASE_A_CODE = 97
private const val UPPERCASE_OFFSET = 26

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
