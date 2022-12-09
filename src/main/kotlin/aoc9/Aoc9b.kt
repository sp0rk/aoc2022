package aoc9

import aoc9.model.Board
import aoc9.model.Direction
import aoc9.model.Move
import core.Aoc
import core.Input

object Aoc9b : Aoc {
    override val inputPath = "/inputs/Aoc9.txt"
    private const val ROPE_LENGTH = 10

    override fun calculateAnswer(input: Input): String {
        val board = Board(ROPE_LENGTH)
        val moves = parseMoves(input.lineStrings)

        moves.forEach(board::move)

        return "${board.uniqueTailPositions}"
    }

    private fun parseMoves(input: List<String>): List<Move> = input.map { move ->
        val (direction, size) = move.split(" ")
        Move(Direction.forSymbol(direction), size.toInt())
    }

}


