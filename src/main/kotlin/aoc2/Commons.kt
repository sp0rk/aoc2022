package aoc2

import aoc2.model.Round
import aoc2.model.RoundResult
import aoc2.model.Throw

object Commons {
    fun parseRounds(input: String) = input.split("\n").map { round ->
        val (opponentThrow, playerInstruction) = round.split(" ")
        Round(
            opponentThrow = Throw.forOpponentSymbol(opponentThrow),
            playerThrow = Throw.forPlayerSymbol(playerInstruction),
            expectedResult = RoundResult.forResultSymbol(playerInstruction)
        )
    }
}
