package aoc5

import core.Aoc
import core.Input
import java.util.*

/***
 * Day 5: Supply Stacks Part Two
 * https://adventofcode.com/2022/day/5
 *
 * The CrateMover 9001 is notable for the ability to pick up and move multiple crates at once.
 *
 * Action of moving three crates from stack 1 to stack 3 means that those three moved crates stay in the same order
 *
 * After the rearrangement procedure completes, what crate ends up on top of each stack?
 */
object Aoc5b : Aoc {
    override val inputPath = "/inputs/Aoc5.txt"
    override fun shouldTrimInput() = false

    override fun calculateAnswer(input: Input): String {
        val (stacks, moves) = parseInput(input)

        moves.forEach { move ->
            val itemsBeingMoved = buildList<String> {
                repeat(move.size) {
                    add(stacks[move.from].pop())
                }
            }.reversed()

            stacks[move.to].addAll(itemsBeingMoved)
        }

        return stacks.joinToString(
            separator = "",
            transform = Stack<String>::peek
        )
    }
}
