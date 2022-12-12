package aoc12

import core.Aoc
import core.Input

object Aoc12b : Aoc {
    override val inputPath = "/inputs/Aoc12.txt"

    override fun calculateAnswer(input: Input): String {
        val heightMap = Commons.parseHeightMap(input.lineStrings)
        val start = heightMap.findElement { it.height == 'E' }

        val shortestDistance = Commons.findShortestPath(heightMap, start, reverseNavigation = true) { position ->
            heightMap[position].height == 'a'
        }
        return "$shortestDistance"
    }
}
