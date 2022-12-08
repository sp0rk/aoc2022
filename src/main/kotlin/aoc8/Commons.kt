package aoc8

import aoc8.model.BoardOfInts

/**
 * @return 2D List of Ints
 */
fun parseTreeBoard(lineStrings: List<String>): BoardOfInts = lineStrings.map { row ->
    row.map(Char::digitToInt)
}



