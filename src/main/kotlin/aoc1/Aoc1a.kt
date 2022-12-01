package aoc1

import aoc1.Commons.calculateCalorieSums
import core.Aoc

object Aoc1a: Aoc {
    override val inputPath = "/inputs/Aoc1.txt"

    override fun calculateAnswer(input: String) : String {
        val calorieSums = calculateCalorieSums(input)
        val maxCaloriesOfAllElves = calorieSums.max()

        return "$maxCaloriesOfAllElves"
    }
}