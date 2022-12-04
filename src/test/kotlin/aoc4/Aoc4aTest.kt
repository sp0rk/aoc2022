package aoc4

import core.AocTest

class Aoc4aTest : AocTest(
    testInput =
    """
        2-4,6-8
        2-3,4-5
        5-7,7-9
        2-8,3-7
        6-6,4-6
        2-6,4-8
    """.trimIndent(),
    expectedOutput = "2",
    sut = Aoc4a
)
