package aoc2

import core.AocTest

class Aoc2aTest : AocTest(
    testInput =
    """
        A Y
        B X
        C Z
    """.trimIndent(),
    expectedOutput = "15",
    sut = Aoc2a
)
