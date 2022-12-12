package aoc12

import commons.Grid
import core.Aoc
import core.Input

object Aoc12a : Aoc {
    override val inputPath = "/inputs/Aoc12.txt"

    override fun calculateAnswer(input: Input): String {
        val heightMap = parseHeightMap(input.lineStrings)
        val start = heightMap.findElement('S')
        val end = heightMap.findElement('E')

        println("S: ${heightMap.connectedNeighbours(start, ::isNavigable)}")
        println("E: ${heightMap.connectedNeighbours(end, ::isNavigable)}")

        return "start $start, end $end"
    }

    private fun isNavigable(origin: Char, target: Char): Boolean {
        fun Char.sanitised() = when (this) {
            'S' -> 'a'
            'E' -> 'z'
            else -> this
        }
        return target.sanitised() - origin.sanitised() >= 0
    }

    private fun parseHeightMap(rows: List<String>) = Grid(
        rows.map { row ->
            row.toList()
        }
    )
}
