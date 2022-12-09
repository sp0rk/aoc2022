package aoc9

import core.AocTest

class Aoc9aTest : AocTest(
    testInput =
    """
        R 4
        U 4
        L 3
        D 1
        R 4
        D 1
        L 5
        R 2
    """.trimIndent(),
    expectedOutput = "13",
    sut = Aoc9a
)
