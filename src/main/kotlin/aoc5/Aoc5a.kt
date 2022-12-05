package aoc5

import aoc5.model.Move
import core.Aoc
import core.Input
import java.util.*

/***
 * Day 5: Supply Stacks
 * https://adventofcode.com/2022/day/5
 *
 * To ensure none of the crates get crushed or fall over, the crane operator will rearrange them in a series of
 * carefully-planned steps.
 *
 * They do, however, have a drawing of the starting stacks of crates and the rearrangement procedure (your puzzle input)
 *
 *     [D]
 * [N] [C]
 * [Z] [M] [P]
 *  1   2   3
 *
 * move 1 from 2 to 1
 * move 3 from 1 to 3
 * move 2 from 2 to 1
 * move 1 from 1 to 2
 *
 * After the rearrangement procedure completes, what crate ends up on top of each stack?
 */
object Aoc5a : Aoc {
    private val MOVE_SEQUENCE_PATTERN = Regex("move (\\d+) from (\\d+) to (\\d+)")
    override val inputPath = "/inputs/Aoc5.txt"
    override fun shouldTrimInput() = false

    override fun calculateAnswer(input: Input): String {
        parseInput(input)

        return "not implemented"
    }

    private fun parseInput(input: Input) {
        val (startingDiagramInput, moveSequenceInput) = input.paragraphs
        val moves = parseMoveSequence(moveSequenceInput)
        val startingStacks = parseStartingDiagram(startingDiagramInput)
    }

    private fun parseMoveSequence(moveSequenceInput: Input) =
        moveSequenceInput.lineStrings.map { moveString ->
            val matches = MOVE_SEQUENCE_PATTERN.matchEntire(moveString)
                ?: throw IllegalArgumentException("$moveString does not match a move sequence pattern")

            val (size, from, to) = matches.destructured

            // Data indexed from 1
            Move(from.toInt() - 1, to.toInt() - 1, size.toInt())
        }

    private fun parseStartingDiagram(startingDiagramInput: Input): List<Stack<String>> {
        // Split each row into discrete items: '[N] [C]    ' -> ['[N] ','[C] ','   ']
        val lines = startingDiagramInput.lineStrings.map { line ->
            line.chunked(4)
        }

        // Convert data from list of rows, to list of columns: ['    ','[N] ','[Z] '' 1 ']
        val stackDiagrams = transpose(lines)

        return stackDiagrams.map(::parseStackDiagram)
    }

    // Convert stack diagram into a sanitised Stack of items: ['    ','[N] ','[Z] '' 1 '] -> Stack("Z","N")
    private fun parseStackDiagram(stackDiagram: List<String>) = stackDiagram
        // Remove stack number
        .dropLast(1)
        // Drop leading empty items
        .dropWhile(String::isBlank)
        // Take item name out of brackets and remove trailing space
        .map { it.substring(1, 2) }
        // starting at the end, push each item onto a Stack
        .foldRight(Stack<String>()) { item, acc ->
            acc.apply {
                push(item)
            }
        }
}
