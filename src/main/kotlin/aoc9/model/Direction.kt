package aoc9.model;

enum class Direction(val symbol: String) {
    UP("U"),
    DOWN("D"),
    LEFT("L"),
    RIGHT("R"),
    ;

    companion object {
        fun forSymbol(symbol: String) = values().first { it.symbol == symbol }
    }
}
