package commons

class Grid<T>(initial: List<List<T>>) : List<List<T>> by initial {
    operator fun get(position: Position) = this[position.y][position.x]

    fun findElement(element: T) =
        indexOfFirst { it.contains(element) }.let { y ->
            this[y].indexOf(element) to y
        }

    fun connectedNeighbours(element: Position, predicate: (origin: T, neighbour: T) -> Boolean) = setOfNotNull(
        upFrom(element)?.takeIf { neighbour -> predicate(this[element], this[neighbour]) },
        downFrom(element)?.takeIf { neighbour -> predicate(this[element], this[neighbour]) },
        leftFrom(element)?.takeIf { neighbour -> predicate(this[element], this[neighbour]) },
        rightFrom(element)?.takeIf { neighbour -> predicate(this[element], this[neighbour]) },
    )

    fun upFrom(position: Position) = if (position.y == 0) {
        null
    } else {
        position + (0 to -1)
    }

    fun downFrom(position: Position) = if (position.y == lastIndex) {
        null
    } else {
        position + (0 to 1)
    }

    fun rightFrom(position: Position) = if (position.x == this[position.y].lastIndex) {
        null
    } else {
        position + (1 to 0)
    }

    fun leftFrom(position: Position) = if (position.x == 0) {
        null
    } else {
        position + (-1 to 0)
    }
}
