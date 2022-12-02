package aoc2

import core.AocTest

class Aoc2bTest : AocTest(
    testInput =
    """
        A Y
        B X
        C Z
    """.trimIndent(),
    expectedOutput = "12",
    sut = Aoc2b
)
