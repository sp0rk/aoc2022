package aoc9.model

import kotlin.math.sign

private val origin: Position
    get() = 0 to 0

class Board(private val ropeNodes: Int = 2) {

    val uniqueTailPositions get() = tailPositions.size
    private val tailPositions = mutableSetOf(origin)

    private val nodePositions = buildList {
        repeat(ropeNodes) {
            add(origin)
        }
    }.toMutableList()

    fun move(move: Move) {
        repeat(move.size) {
            moveHead(move.direction)
            moveNextNodeIfNeeded(1)
            tailPositions.add(nodePositions.last())
        }
    }

    private fun moveHead(direction: Direction) {
        nodePositions[0] += when (direction) {
            Direction.UP -> 0 to -1
            Direction.DOWN -> 0 to 1
            Direction.LEFT -> -1 to 0
            Direction.RIGHT -> 1 to 0
        }
    }

    // Assume tail=current node, head=its parent.
    private fun moveNextNodeIfNeeded(index: Int) {
        val head = nodePositions[index - 1]
        val tail = nodePositions[index]

        val headToTailVector = head.x - tail.x to head.y - tail.y
        // Check if position is valid
        when (headToTailVector) {
            0 to 0 -> {
                return // tail is on head
            }

            0 to 1, 0 to -1, 1 to 0, -1 to 0 -> {
                return // tail is edge-wise adjacent
            }

            1 to 1, 1 to -1, -1 to 1, -1 to -1 -> {
                return // tail is corner-wise adjacent
            }
        }

        // If position is not valid, move tail
        nodePositions[index] += headToTailVector.x.sign to headToTailVector.y.sign

        if (index != nodePositions.lastIndex) {
            moveNextNodeIfNeeded(index + 1)
        }
    }

    // Align drawing size and offset to input data
    override fun toString(): String {
        val drawingSize = 50
        val offset = 24
        val board = buildList {
            repeat(drawingSize) {
                add(buildList {
                    repeat(drawingSize) {
                        add(".")
                    }
                }.toMutableList())
            }
        }

        board[offset][offset] = "s"
        nodePositions.reversed().forEachIndexed { i, n ->
            board[n.y + offset][n.x + offset] = if (ropeNodes - i - 1 == 0) "H" else "${ropeNodes - i - 1}"
        }

        return buildString {
            for (row in board) {
                appendLine(row.joinToString(" "))
            }
        }
    }
}
