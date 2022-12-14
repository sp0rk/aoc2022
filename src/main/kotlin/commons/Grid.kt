package commons

class Grid<T>(initial: MutableList<MutableList<T>>) : MutableList<MutableList<T>> by initial {
    val positions = buildSet {
        this@Grid.forEachIndexed { y, _ ->
            this@Grid[y].forEachIndexed { x, _ ->
                add(Position(x, y))
            }
        }
    }

    operator fun get(position: Position) = this[position.y][position.x]
    operator fun set(position: Position, value: T) {
        this[position.y][position.x] = value
    }

    fun findElement(element: T): Position =
        indexOfFirst { it.contains(element) }.let { y ->
            this[y].indexOf(element) to y
        }

    fun findElement(predicate: (T) -> Boolean): Position =
        indexOfFirst { it.any(predicate) }.let { y ->
            this[y].indexOfFirst(predicate) to y
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
