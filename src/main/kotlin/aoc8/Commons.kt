package aoc8

import commons.Grid

/**
 * @return 2D List of Ints
 */
fun parseTreeBoard(lineStrings: List<String>): Grid<Int> = Grid(
    lineStrings.map { row ->
        row.map(Char::digitToInt).toMutableList()
    }.toMutableList()
)



