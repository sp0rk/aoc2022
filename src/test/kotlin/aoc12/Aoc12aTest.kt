package aoc12

import core.AocTest

class AocTest12a : AocTest(
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
