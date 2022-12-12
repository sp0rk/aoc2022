package aoc12

import aoc12.model.Node
import commons.Grid
import commons.Position

object Commons {
    fun parseHeightMap(rows: List<String>) = Grid(
        rows.map { row ->
            row.toList().map { height ->
                Node(height = height, tentativeDistance = Int.MAX_VALUE)
            }
        }
    )

    fun findShortestPath(
        heightMap: Grid<Node>,
        start: Position,
        reverseNavigation: Boolean,
        endCondition: (Position) -> Boolean
    ): Int {
        val unvisitedPositions = heightMap.positions.toMutableSet()

        var currentPosition: Position = start
        heightMap[start].tentativeDistance = 0
        heightMap[start].tentativePath = listOf(start)

        while (!endCondition(currentPosition)) {
//            println("Considering $currentPosition: ${heightMap[currentPosition]}. Unvisited left: $unvisitedPositions")
            val connectedNeighbours = heightMap.connectedNeighbours(currentPosition) { origin, neighbour ->
                if (reverseNavigation) {
                    isNavigable(neighbour, origin)
                } else {
                    isNavigable(origin, neighbour)
                }
            }
            connectedNeighbours
                .filter { it in unvisitedPositions }
                .forEach { neighbour ->
                    val proposedDistance = heightMap[currentPosition].tentativeDistance + 1
                    if (heightMap[neighbour].tentativeDistance > proposedDistance) {
                        heightMap[neighbour].tentativeDistance = proposedDistance
                        heightMap[neighbour].tentativePath = heightMap[currentPosition].tentativePath + neighbour
                    }
                }
            unvisitedPositions.remove(currentPosition)
            currentPosition = unvisitedPositions.minBy { heightMap[it].tentativeDistance }
        }

        return heightMap[currentPosition].tentativeDistance
    }

    private fun isNavigable(origin: Node, target: Node): Boolean {
        fun Char.sanitised() = when (this) {
            'S' -> 'a'
            'E' -> 'z'
            else -> this
        }
        return target.height.sanitised() - origin.height.sanitised() <= 1
    }
}
