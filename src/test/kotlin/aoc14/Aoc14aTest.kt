package aoc14

import core.AocTest

class Aoc14aTest : AocTest(
    testInput =
    """
        498,4 -> 498,6 -> 496,6
        503,4 -> 502,4 -> 502,9 -> 494,9
    """.trimIndent(),
    expectedOutput = "24",
    sut = Aoc14a
)
