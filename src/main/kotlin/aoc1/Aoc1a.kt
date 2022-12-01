package aoc1

import aoc1.Commons.calculateCalorieSums
import core.Aoc

/***
 * Day 1: Calorie Counting
 * https://adventofcode.com/2022/day/1
 *
 * The jungle must be too overgrown and difficult to navigate in vehicles or access from the air; the Elves' expedition
 * traditionally goes on foot. As your boats approach land, the Elves begin taking inventory of their supplies.
 * One important consideration is food - in particular, the number of Calories each Elf is carrying (your puzzle input).
 *
 * The Elves take turns writing down the number of Calories contained by the various meals, snacks,
 * rations, etc. that they've brought with them, one item per line. Each Elf separates their own inventory from the
 * previous Elf's inventory (if any) by a blank line.
 *
 * Find the Elf carrying the most Calories. How many total Calories is that Elf carrying?
 */

object Aoc1a : Aoc {
    override val inputPath = "/inputs/Aoc1.txt"

    override fun calculateAnswer(input: String): String {
        val calorieSums = calculateCalorieSums(input)
        val maxCaloriesOfAllElves = calorieSums.max()

        return "$maxCaloriesOfAllElves"
    }
}