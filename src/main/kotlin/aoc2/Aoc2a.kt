package aoc2

import aoc2.Commons.parseRounds
import core.Aoc
import core.Input

/***
 * Day 2: Rock Paper Scissors
 * https://adventofcode.com/2022/day/2
 *
 * The first column is what your opponent is going to play: A for Rock, B for Paper, and C for Scissors.
 * The second column, you reason, must be what you should play in response: X for Rock, Y for Paper, and Z for Scissors.
 *
 *  Your total score is the sum of your scores for each round.
 * The score for a single round is the score for the shape you selected (1 for Rock, 2 for Paper, and 3 for Scissors)
 * plus the score for the outcome of the round (0 if you lost, 3 if the round was a draw, and 6 if you won).
 *
 * What would your total score be if everything goes exactly according to your strategy guide?
 */
object Aoc2a : Aoc {
    override val inputPath = "/inputs/Aoc2.txt"

    override fun calculateAnswer(input: Input): String {
        val rounds = parseRounds(input)
        val totalScore = rounds.sumOf { round ->
            round.calculatePoints(forUpdatedStrategy = false)
        }

        return "$totalScore"
    }
}
