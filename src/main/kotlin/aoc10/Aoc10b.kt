package aoc10

import aoc10.CommandMapper.constructRegisterHistoryFromCommands
import core.Aoc
import core.Input

object Aoc10b : Aoc {
    override val inputPath = "/inputs/Aoc10.txt"

    override fun calculateAnswer(input: Input): String {
        val registerValues = constructRegisterHistoryFromCommands(input.lineStrings)

        val render = registerValues
            // drop post last cycle value
            .dropLast(1)
            // check if pixel lit
            .mapIndexed { index, registerValue ->
                if (index % 40 in registerValue - 1..registerValue + 1) {
                    "#"
                } else {
                    "."
                }
            }
            // divide lines
            .chunked(40)
            // convert nested list to string
            .joinToString("\n") {
                it.joinToString("")
            }

        return render
    }
}
