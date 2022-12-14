package aoc14.model

import commons.*

object Commons {

    fun Grid<Tile>.asString(): String = buildString {
        this@asString.forEach { row ->
            row.forEach { tile ->
                append(tile.asString)
            }
            appendLine()
        }
    }

    // null if out of bounds, unchanged if came to stop
    fun Grid<Tile>.nextSandPosition(currentSandPosition: Position): Position? = when {
        downFrom(currentSandPosition)?.let(::get) == Tile.AIR -> {
            downFrom(currentSandPosition)
        }

        downFrom(currentSandPosition)?.let(::leftFrom)?.let(::get) == Tile.AIR -> {
            leftFrom(downFrom(currentSandPosition)!!)
        }

        downFrom(currentSandPosition)?.let(::rightFrom)?.let(::get) == Tile.AIR -> {
            rightFrom(downFrom(currentSandPosition)!!)
        }

        downFrom(currentSandPosition)?.let(::get) == null -> {
            null
        }

        downFrom(currentSandPosition)?.let(::leftFrom)?.let(::get) == null -> {
            null
        }

        downFrom(currentSandPosition)?.let(::rightFrom)?.let(::get) == null -> {
            null
        }

        else -> {
            currentSandPosition
        }
    }

    fun parseCave(lines: List<String>): Grid<Tile> {
        val cave = hashMapOf(Position(500, 0) to Tile.SOURCE)

        lines.forEach { line ->
            val wall = parseWall(line.split(" -> "))

            // fill walls
            wall.forEach { (start, end) ->
                val isHorizontal = start.y == end.y
                if (isHorizontal) {
                    val range = if (start.x < end.x) {
                        start.x..end.x
                    } else {
                        end.x..start.x
                    }
                    for (x in range) {
                        cave[x to start.y] = Tile.WALL
                    }
                } else {
                    val range = if (start.y < end.y) {
                        start.y..end.y
                    } else {
                        end.y..start.y
                    }
                    for (y in range) {
                        cave[start.x to y] = Tile.WALL
                    }
                }
            }
        }

        val minY = cave.keys.minBy(Position::y).y
        val maxY = cave.keys.maxBy(Position::y).y
        val minX = cave.keys.minBy(Position::x).x
        val maxX = cave.keys.maxBy(Position::x).x

        return Grid(
            buildList {
                for (y in minY..maxY) {
                    add(
                        buildList {
                            for (x in minX..maxX) {
                                add(cave.getOrDefault(x to y, Tile.AIR))
                            }
                        }.toMutableList()
                    )
                }
            }.toMutableList()
        )
    }

    // [(498,4), (498,6), (496,6)] -> [(498,4) to (498,6), (498,6) to (496,6)]
    private fun parseWall(wall: List<String>) = List(wall.size) { index ->
        if (index < wall.lastIndex) {
            positionFromString(wall[index]) to positionFromString(wall[index + 1])
        } else {
            null
        }
    }.filterNotNull()

}
