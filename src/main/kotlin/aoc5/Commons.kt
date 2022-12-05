package aoc5

import aoc5.model.Move
import core.Input
import java.util.*

/**
 * @param 2D list of values
 * e.g.
 * [
 *  [A,B,C],
 *  [0,1,2],
 *  [X,Y,Z]
 * ]
 *
 * @return 2D list of same values with rows, and columns swapped
 * e.g.
 * [
 *  [A,0,X],
 *  [B,1,Y],
 *  [C,2,Z]
 * ]
 */
fun <T> transpose(list: List<List<T>>): List<List<T>> {
    val transposedListSize = list.first().size
    val transposedList = buildList<MutableList<T>> { repeat(transposedListSize) { add(mutableListOf()) } }

    list.forEach { sublist ->
        sublist.forEachIndexed { index, item ->
            transposedList[index].add(item)
        }
    }

    return transposedList
}

fun parseInput(input: Input): Pair<List<Stack<String>>, List<Move>> {
    val (startingDiagramInput, moveSequenceInput) = input.paragraphs
    val moves = parseMoveSequence(moveSequenceInput)
    val stacks = parseStartingDiagram(startingDiagramInput)

    return stacks to moves
}

fun parseMoveSequence(moveSequenceInput: Input) =
    moveSequenceInput.lineStrings.filter(String::isNotEmpty).map { moveString ->
        val matches = MOVE_SEQUENCE_PATTERN.matchEntire(moveString)
            ?: throw IllegalArgumentException("$moveString does not match a move sequence pattern")

        val (size, from, to) = matches.destructured

        // Data indexed from 1
        Move(from.toInt() - 1, to.toInt() - 1, size.toInt())
    }

fun parseStartingDiagram(startingDiagramInput: Input): List<Stack<String>> {
    // Split each row into discrete items: '[N] [C]    ' -> ['[N] ','[C] ','   ']
    val lines = startingDiagramInput.lineStrings.map { line ->
        line.chunked(4)
    }

    // Convert data from list of rows, to list of columns: ['    ','[N] ','[Z] '' 1 ']
    val stackDiagrams = transpose(lines)

    return stackDiagrams.map(::parseStackDiagram)
}

// Convert stack diagram into a sanitised Stack of items: ['    ','[N] ','[Z] '' 1 '] -> Stack("Z","N")
fun parseStackDiagram(stackDiagram: List<String>) = stackDiagram
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

@Suppress("PrivatePropertyName") // const
private val MOVE_SEQUENCE_PATTERN = Regex("move (\\d+) from (\\d+) to (\\d+)")
