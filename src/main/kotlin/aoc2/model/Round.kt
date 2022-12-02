package aoc2.model

data class Round(
    val opponentThrow: Throw,
    val playerThrow: Throw
) {
    val result = playerThrow versus opponentThrow
    val points = result.points + playerThrow.points
}
