package aoc9.model

private val origin: Position
    get() = 0 to 0

class Board {
    val tailPositions = mutableSetOf(origin)

    private var head = origin
    private var tail = origin

    fun move(move: Move) {
        repeat(move.size) {
            moveHead(move.direction)
            moveTailIfNeeded()
            tailPositions.add(tail)
        }
    }

    private fun moveHead(direction: Direction) {
        head += when (direction) {
            Direction.UP -> 0 to -1
            Direction.DOWN -> 0 to 1
            Direction.LEFT -> -1 to 0
            Direction.RIGHT -> 1 to 0
        }
    }

    private fun moveTailIfNeeded() {
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
        tail = if (headToTailVector.x == 2) {
            tail.x + 1 to head.y
        } else if (headToTailVector.x == -2) {
            tail.x + -1 to head.y
        } else if (headToTailVector.y == 2) {
            head.x to tail.y + 1
        } else if (headToTailVector.y == -2) {
            head.x to tail.y - 1
        } else {
            throw IllegalStateException("head: $head, tail: $tail. Is not a valid position")
        }
    }
}
