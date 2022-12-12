package aoc12

import core.AocTest

class Aoc12bTest : AocTest(
    testInput =
    """
        Sabqponm
        abcryxxl
        accszExk
        acctuvwj
        abdefghi
    """.trimIndent(),
    expectedOutput = "29",
    sut = Aoc12b
)
