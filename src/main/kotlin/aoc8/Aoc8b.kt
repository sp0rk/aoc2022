package aoc8

import aoc8.model.Direction
import commons.Grid
import commons.Position
import core.Aoc
import core.Input

/**
 * Day 8: Treetop Tree House Part Two
 * https://adventofcode.com/2022/day/8
 *
 */
object Aoc8b : Aoc {
    override val inputPath = "/inputs/Aoc8.txt"

    override fun calculateAnswer(input: Input): String {
        val board = parseTreeBoard(input.lineStrings)

        val scenicScores = board
            .flatMapIndexed { x, row ->
                List(row.size) { y ->
                    Direction.values().map { direction ->
                        scenicScore(board, x to y, direction)
                    }.reduce { acc, i ->
                        acc * i
                    }
                }
            }

        val bestScenicScore = scenicScores.max()

        return "$bestScenicScore"

    }

    private fun scenicScore(board: Grid<Int>, treeIndices: Position, direction: Direction): Int {
        val (x, y) = treeIndices
        val tree = board[x][y]

        var counter = 0
        when (direction) {
            Direction.TOP -> {
                if (x == 0) {
                    return 0
                }
                for (i in x - 1 downTo 0) {
                    if (board[i][y] < tree) {
                        ++counter
                    } else {
                        return ++counter
                    }
                }
            }

            Direction.DOWN -> {
                if (x == board.lastIndex) {
                    return 0
                }
                for (i in x + 1..board.lastIndex) {
                    if (board[i][y] < tree) {
                        ++counter
                    } else {
                        return ++counter
                    }
                }
            }

            Direction.LEFT -> {
                if (y == 0) {
                    return 0
                }
                for (i in y - 1 downTo 0) {
                    if (board[x][i] < tree) {
                        ++counter
                    } else {
                        return ++counter
                    }
                }
            }

            Direction.RIGHT -> {
                if (y == board[x].lastIndex) {
                    return 0
                }
                for (i in y + 1..board[x].lastIndex) {
                    if (board[x][i] < tree) {
                        ++counter
                    } else {
                        return ++counter
                    }
                }
            }
        }
        return counter
    }
}


