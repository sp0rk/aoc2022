package aoc2.model

data class Round(
    val opponentThrow: Throw,
    val playerThrow: Throw,

    // For updated strategy / part 2
    val expectedResult: RoundResult,
) {
    private val result = playerThrow versus opponentThrow

    // For updated strategy / part 2
    private val expectedThrow: Throw = Throw.forResult(expectedResult, opponentThrow)

    fun calculatePoints(forUpdatedStrategy: Boolean) = if (forUpdatedStrategy) {
        expectedResult.points + expectedThrow.points
    } else {
        result.points + playerThrow.points
    }
}
