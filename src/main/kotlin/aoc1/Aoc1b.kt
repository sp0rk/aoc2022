package aoc1

import aoc1.Commons.calculateCalorieSums
import core.Aoc

object Aoc1b: Aoc {
    override val inputPath = "/inputs/Aoc1.txt"

    override fun calculateAnswer(input: String) : String {
        val calorieSumsDescending = calculateCalorieSums(input).sortedDescending()
        val bestThreeSums = calorieSumsDescending.take(3)
        val sumOfBestThree = bestThreeSums.sum()

        return "$sumOfBestThree"
    }
}