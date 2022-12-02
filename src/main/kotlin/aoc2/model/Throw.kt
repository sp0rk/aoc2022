package aoc2.model

enum class Throw(
    val points: Int,
    val opponentSymbol: String,
    val playerSymbol: String
) {
    ROCK(1, "A", "X"),
    PAPER(2, "B", "Y"),
    SCISSORS(3, "C", "Z"),
    ;

    companion object {
        fun forOpponentSymbol(symbol: String) = values().firstOrNull { it.opponentSymbol == symbol }
            ?: throw IllegalArgumentException("No throw for opponent symbol $symbol")

        fun forPlayerSymbol(symbol: String) = values().firstOrNull { it.playerSymbol == symbol }
            ?: throw IllegalArgumentException("No throw for player symbol $symbol")
    }
}

infix fun Throw.versus(opponentThrow: Throw): RoundResult =
    if (this == opponentThrow) {
        RoundResult.DRAW
    } else if (this beats opponentThrow) {
        RoundResult.WIN
    } else {
        RoundResult.LOSS
    }

private infix fun Throw.beats(opponentThrow: Throw) = when (this) {
    Throw.ROCK -> opponentThrow == Throw.SCISSORS
    Throw.PAPER -> opponentThrow == Throw.ROCK
    Throw.SCISSORS -> opponentThrow == Throw.PAPER
}
