package aoc11

import aoc11.Commons.parseMonkeys
import aoc11.Commons.playRound
import aoc11.model.Monkey
import core.Aoc
import core.Input

object Aoc11b : Aoc {
    override val inputPath = "/inputs/Aoc11.txt"

    override fun calculateAnswer(input: Input): String {
        val monkeys = parseMonkeys(input.paragraphs)

        repeat(10_000) {
            playRound(monkeys, reduceItemOnInspection = false)
        }

        val monkeyBusinessLevel = monkeys
            .map(Monkey::monkeyBusinessFactor)
            .sortedDescending()
            .take(2)
            .reduce { acc, i -> acc * i }

        return "$monkeyBusinessLevel"
    }

}
