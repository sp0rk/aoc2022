package aoc1

import aoc1.Commons.calculateCalorieSums
import core.Aoc

/***
 * Day 1: Calorie Counting Part Two
 * https://adventofcode.com/2022/day/1
 *
 * By the time you calculate the answer to the Elves' question, they've already realized that the Elf carrying
 * the most Calories of food might eventually run out of snacks.
 *
 * To avoid this unacceptable situation, the Elves would instead like to know the total Calories carried by the top
 * three Elves carrying the most Calories. That way, even if one of those Elves runs out of snacks,
 * they still have two backups.
 *
 *  Find the top three Elves carrying the most Calories. How many Calories are those Elves carrying in total?
 */

object Aoc1b : Aoc {
    override val inputPath = "/inputs/Aoc1.txt"

    override fun calculateAnswer(input: String): String {
        val calorieSumsDescending = calculateCalorieSums(input).sortedDescending()
        val bestThreeSums = calorieSumsDescending.take(3)
        val sumOfBestThree = bestThreeSums.sum()

        return "$sumOfBestThree"
    }
}