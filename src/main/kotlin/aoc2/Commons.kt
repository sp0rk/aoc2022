package aoc2

import aoc2.model.Round
import aoc2.model.RoundResult
import aoc2.model.Throw
import core.Input

object Commons {
    fun parseRounds(input: Input) = input.lines.map { round ->
        val (opponentThrow, playerInstruction) = round.wordStrings
        Round(
            opponentThrow = Throw.forOpponentSymbol(opponentThrow),
            playerThrow = Throw.forPlayerSymbol(playerInstruction),
            expectedResult = RoundResult.forResultSymbol(playerInstruction)
        )
    }
}
