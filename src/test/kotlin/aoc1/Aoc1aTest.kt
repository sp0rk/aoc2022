package aoc1

import core.AocTest

class Aoc1aTest : AocTest(
    testInput =
    """
        1000
        2000
        3000
        
        4000
        
        5000
        6000
        
        7000
        8000
        9000
        
        10000
    """.trimIndent(),
    expectedOutput = "24000",
    sut = Aoc1a
)
