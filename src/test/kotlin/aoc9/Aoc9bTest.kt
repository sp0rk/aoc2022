package aoc9

import core.AocTest

class Aoc9bTest : AocTest(
    Aoc9b,
    """
        R 4
        U 4
        L 3
        D 1
        R 4
        D 1
        L 5
        R 2
    """.trimIndent() to "1",
    """
        R 5
        U 8
        L 8
        D 3
        R 17
        D 10
        L 25
        U 20
    """.trimIndent() to "19"
)
