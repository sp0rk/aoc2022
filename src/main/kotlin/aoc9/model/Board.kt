package aoc9.model

private val origin: Position
    get() = 0 to 0

class Board {
    var head = origin
    var tail = origin
    val tailPositions = setOf<Position>()

    fun move(move: Move) {
        repeat(move.size) {
            moveHead(move.direction)
            moveTailIfNeeded()
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

    }
}
