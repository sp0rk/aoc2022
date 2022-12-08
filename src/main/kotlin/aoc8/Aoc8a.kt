package aoc8

import aoc8.model.Direction
import core.Aoc
import core.Input

/**
 * Day 8: Treetop Tree House
 * https://adventofcode.com/2022/day/8
 *
 * First, determine whether there is enough tree cover here to keep a tree house hidden.
 * To do this, you need to count the number of trees that are visible from outside the grid when looking
 * directly along a row or column.
 *
 * The Elves have already launched a quadcopter to generate a map with the height of each tree (your puzzle input).
 *
 * Each tree is represented as a single digit whose value is its height, where 0 is the shortest and 9 is the tallest.
 *
 * A tree is visible if all the other trees between it and an edge of the grid are shorter than it.
 * Only consider trees in the same row or column; that is, only look up, down, left, or right from any given tree.
 *
 * Consider your map; how many trees are visible from outside the grid?
 */
object Aoc8a : Aoc {
    override val inputPath = "/inputs/Aoc8.txt"

    override fun calculateAnswer(input: Input): String {
        val board = parseTreeBoard(input.lineStrings)

        val visibleTreeCount = board
            .flatMapIndexed { x, row ->
                List(row.size) { y ->
                    Direction.values().any { direction ->
                        !isObscured(board, x to y, direction)
                    }
                }
            }.count { it }

        return "$visibleTreeCount"
    }
}


