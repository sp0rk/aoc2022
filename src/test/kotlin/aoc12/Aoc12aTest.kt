package aoc12

import core.AocTest

class Aoc12aTest : AocTest(
    testInput =
    """
        Sabqponm
        abcryxxl
        accszExk
        acctuvwj
        abdefghi
    """.trimIndent(),
    expectedOutput = "31",
    sut = Aoc12a
)
