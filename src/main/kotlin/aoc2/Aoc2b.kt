package aoc2

import aoc2.Commons.parseRounds
import aoc2.model.Round
import aoc2.model.Throw
import core.Aoc

/***
 * Day 2: Rock Paper Scissors Part Two
 * https://adventofcode.com/2022/day/2
 *
 * The Elf finishes helping with the tent and sneaks back over to you. "Anyway, the second column says
 * how the round needs to end:
 * X means you need to lose, Y means you need to end the round in a draw, and Z means you need to win.
 *
 * The total score is still calculated in the same way, but now you need to figure out what shape to choose
 * so the round ends as indicated.
 *
 * Following the Elf's instructions for the second column,
 * what would your total score be if everything goes exactly according to your strategy guide?
 */
object Aoc2b : Aoc {
    override val inputPath = "/inputs/Aoc2.txt"

    override fun calculateAnswer(input: String): String {
        val rounds = parseRounds(input)
        val totalScore = rounds.sumOf { round ->
            round.calculatePoints(forUpdatedStrategy = true)
        }

        return "$totalScore"
    }
}
