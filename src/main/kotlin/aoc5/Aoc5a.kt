package aoc5

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
    override val inputPath = "/inputs/Aoc5.txt"
    override fun shouldTrimInput() = false

    override fun calculateAnswer(input: Input): String {
        val (stacks, moves) = parseInput(input)

        moves.forEach { move ->
            repeat(move.size) {
                val itemBeingMoved = stacks[move.from].pop()
                stacks[move.to].push(itemBeingMoved)
            }
        }

        return stacks.joinToString(
            separator = "",
            transform = Stack<String>::peek
        )
    }
}
