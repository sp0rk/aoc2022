package aoc9

import aoc9.model.Board
import aoc9.model.Direction
import aoc9.model.Move
import core.Aoc
import core.Input

object Aoc9a : Aoc {
    override val inputPath = "/inputs/Aoc9.txt"

    override fun calculateAnswer(input: Input): String {
        val board = Board()
        val moves = parseMoves(input.lineStrings)

        moves.forEach(board::move)

        val uniqueTailPositions = board.tailPositions.size
        return "$uniqueTailPositions"
    }

    private fun parseMoves(input: List<String>): List<Move> = input.map { move ->
        val (direction, size) = move.split(" ")
        Move(Direction.forSymbol(direction), size.toInt())
    }

}


