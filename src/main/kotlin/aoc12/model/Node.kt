package aoc12.model

import commons.Position

data class Node(
    val height: Char,
    var tentativeDistance: Int = Int.MAX_VALUE,
    var tentativePath: List<Position> = emptyList(),
)
