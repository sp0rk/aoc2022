import com.github.spork.aoc2022.Aoc1a
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