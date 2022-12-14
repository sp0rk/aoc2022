package aoc14

import aoc14.model.Commons
import aoc14.model.Tile
import commons.*
import core.Aoc
import core.Input

object Aoc14b : Aoc {
    override val inputPath = "/inputs/Aoc14.txt"

    override fun calculateAnswer(input: Input): String {
        val cave = MapGrid(parseCave(input.lineStrings))
        val source = Position(500, 0)

        var currentSandPosition: Position = source
        var sandSpawned = 0

        do {
            // spawn sand
            var previousSandPosition: Position?
            currentSandPosition = source
            do {
                previousSandPosition = currentSandPosition
                currentSandPosition = cave.nextSandPosition(currentSandPosition)!!
            } while (currentSandPosition != previousSandPosition)

            cave[currentSandPosition] = Tile.SAND
            sandSpawned++
        } while (currentSandPosition != source)

        printCave(cave)

        return "$sandSpawned"
    }

    // null if out of bounds, unchanged if came to stop
    fun Positional<Tile>.nextSandPosition(currentSandPosition: Position): Position? = when {
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
            downFrom(currentSandPosition)
        }

        downFrom(currentSandPosition)?.let(::leftFrom)?.let(::get) == null -> {
            leftFrom(downFrom(currentSandPosition)!!)
        }

        downFrom(currentSandPosition)?.let(::rightFrom)?.let(::get) == null -> {
            rightFrom(downFrom(currentSandPosition)!!)
        }

        else -> {
            currentSandPosition
        }
    }

    fun parseCave(lines: List<String>): MapGrid<Tile> {
        val cave = hashMapOf(Position(500, 0) to Tile.SOURCE)

        lines.forEach { line ->
            val wall = Commons.parseWall(line.split(" -> "))

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

        val maxY = cave.keys.maxBy(Position::y).y
        val caveGrid = MapGrid(cave)
        caveGrid.addFloorBelowMaxY(maxY, Tile.WALL)

        return caveGrid
    }

    fun printCave(cave: MapGrid<Tile>) {
        val minY = cave.keys.minBy(Position::y).y
        val maxY = cave.keys.maxBy(Position::y).y
        val minX = cave.keys.minBy(Position::x).x
        val maxX = cave.keys.maxBy(Position::x).x

        for (y in minY .. maxY) {
            for (x in minX .. maxX) {
                print(cave[x to y]?.asString ?: ".")
            }
            println()
        }
    }
}
