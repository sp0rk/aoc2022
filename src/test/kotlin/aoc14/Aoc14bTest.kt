package aoc14

import core.AocTest

class Aoc14bTest : AocTest(
    testInput =
    """
        498,4 -> 498,6 -> 496,6
        503,4 -> 502,4 -> 502,9 -> 494,9
    """.trimIndent(),
    expectedOutput = "93",
    sut = Aoc14b
)
