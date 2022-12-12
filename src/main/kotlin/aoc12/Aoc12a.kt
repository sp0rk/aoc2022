package aoc12

import aoc12.Commons.findShortestPath
import aoc12.Commons.parseHeightMap
import aoc12.model.Node
import commons.Grid
import commons.Position
import core.Aoc
import core.Input

object Aoc12a : Aoc {
    override val inputPath = "/inputs/Aoc12.txt"

    override fun calculateAnswer(input: Input): String {
        val heightMap = parseHeightMap(input.lineStrings)
        val start = heightMap.findElement { it.height == 'S' }

        val shortestDistance = findShortestPath(heightMap, start, reverseNavigation = false) { position ->
            heightMap[position].height == 'E'
        }
        return "$shortestDistance"
    }
}
