package aoc10

import aoc10.CommandMapper.constructRegisterHistoryFromCommands
import core.Aoc
import core.Input

object Aoc10a : Aoc {
    override val inputPath = "/inputs/Aoc10.txt"

    override fun calculateAnswer(input: Input): String {
        val interestingCycles = listOf(20, 60, 100, 140, 180, 220)
        val registerValues = constructRegisterHistoryFromCommands(input.lineStrings)

        val interestingSignalStrengthSum = interestingCycles.sumOf { index ->
            index * registerValues[index - 1]
        }

        return "$interestingSignalStrengthSum"
    }
}
