package aoc5

import core.AocTest

class Aoc5aTest : AocTest(
    testInput =
    """
        |    [D]    
        |[N] [C]    
        |[Z] [M] [P]
        | 1   2   3 
        |
        |move 1 from 2 to 1
        |move 3 from 1 to 3
        |move 2 from 2 to 1
        |move 1 from 1 to 2
    """.trimMargin(),
    expectedOutput = "CMZ",
    sut = Aoc5a
)
