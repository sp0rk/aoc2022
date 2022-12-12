package aoc12

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
        val end = heightMap.findElement { it.height == 'E' }

        val unvisitedPositions = heightMap.positions.toMutableSet()

        var currentPosition: Position = start
        heightMap[start].tentativeDistance = 0

        while (currentPosition != end) {
            println("Considering $currentPosition: ${heightMap[currentPosition]}")
            val connectedNeighbours = heightMap.connectedNeighbours(currentPosition, ::isNavigable)
            connectedNeighbours
                .filter { it in unvisitedPositions }
                .forEach { neighbour ->
                    val proposedDistance = heightMap[currentPosition].tentativeDistance + 1
                    if (heightMap[neighbour].tentativeDistance > proposedDistance) {
                        heightMap[neighbour].tentativeDistance = proposedDistance
                    }
                }
            unvisitedPositions.remove(currentPosition)
            currentPosition = unvisitedPositions.minBy { heightMap[it].tentativeDistance }
        }

        val shortestDistance = heightMap[currentPosition].tentativeDistance

        return "$shortestDistance"
    }

    private fun isNavigable(origin: Node, target: Node): Boolean {
        fun Char.sanitised() = when (this) {
            'S' -> 'a'
            'E' -> 'z'
            else -> this
        }
        return target.height.sanitised() - origin.height.sanitised() >= 0
    }

    private fun parseHeightMap(rows: List<String>) = Grid(
        rows.map { row ->
            row.toList().map { height ->
                Node(height = height, tentativeDistance = Int.MAX_VALUE)
            }
        }
    )
}
