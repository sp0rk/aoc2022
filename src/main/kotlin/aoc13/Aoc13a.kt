package aoc13

import aoc13.Commons.parsePairs
import core.Aoc
import core.Input

object Aoc13a : Aoc {
    override val inputPath = "/inputs/Aoc13.txt"

    override fun calculateAnswer(input: Input): String {
        val pairs = parsePairs(input.paragraphs)

        val indicesOfCorrectPairs = pairs.mapIndexed { index, (left, right) ->
            if (left < right) {
                index + 1
            } else {
                0
            }
        }.sum()

        return "$indicesOfCorrectPairs"
    }
}

