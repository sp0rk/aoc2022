package aoc8

import aoc8.model.BoardOfInts
import aoc8.model.Direction

fun isObscured(board: BoardOfInts, treeIndices: Pair<Int, Int>, direction: Direction): Boolean {
    val (x, y) = treeIndices
    val tree = board[x][y]

    when (direction) {
        Direction.TOP -> {
            if (x == 0) {
                return false
            }
            for (i in 0 until x) {
                if (board[i][y] >= tree) {
                    return true
                }
            }
        }

        Direction.DOWN -> {
            if (y == board.lastIndex) {
                return false
            }
            for (i in x + 1..board.lastIndex) {
                if (board[i][y] >= tree) {
                    return true
                }
            }
        }

        Direction.LEFT -> {
            if (y == 0) {
                return false
            }
            for (i in 0 until y) {
                if (board[x][i] >= tree) {
                    return true
                }
            }
        }

        Direction.RIGHT -> {
            if (y == board[x].lastIndex) {
                return false
            }
            for (i in y + 1..board[x].lastIndex) {
                if (board[x][i] >= tree) {
                    return true
                }
            }
        }
    }
    return false
}

/**
 * @return 2D List of Ints
 */
fun parseTreeBoard(lineStrings: List<String>): BoardOfInts = lineStrings.map { row ->
    row.map(Char::digitToInt)
}



