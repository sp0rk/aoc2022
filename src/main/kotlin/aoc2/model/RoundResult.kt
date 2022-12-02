package aoc2.model

enum class RoundResult(val points: Int, val resultSymbol: String) {
    WIN(6, "Z"),
    DRAW(3, "Y"),
    LOSS(0, "X"),
    ;

    companion object {
        fun forResultSymbol(symbol: String) = values().firstOrNull { it.resultSymbol == symbol }
            ?: throw IllegalArgumentException("No result for result symbol $symbol")
    }
}
