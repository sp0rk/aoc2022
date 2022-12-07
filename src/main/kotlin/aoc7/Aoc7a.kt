package aoc7

import core.Aoc
import core.Input

/**
 * Day 7: No Space Left On Device
 * https://adventofcode.com/2022/day/7
 *
 * You browse around the filesystem to assess the situation and save the resulting terminal output (your puzzle input).
 *
 * The filesystem consists of a tree of files (plain data) and directories (which can contain other directories
 * or files). The outermost directory is called /.
 *
 * Within the terminal output, lines that begin with $ are commands you executed, very much like some modern computers:
 *
 * cd x moves in one level.
 * cd .. moves out one level.
 * cd / switches the current directory to the outermost directory, /.
 * ls means list. It prints out all the files and directories immediately contained by the current directory:
 *
 * 123 abc means that the current directory contains a file named abc with size 123.
 * dir xyz means that the current directory contains a directory named xyz.
 *
 * The total size of a directory is the sum of the sizes of the files it contains, directly or indirectly.
 *
 * Find all the directories with a total size of at most 100000.
 * What is the sum of the total sizes of those directories?
 */
object Aoc7a : Aoc {
    override val inputPath = "/inputs/Aoc7.txt"

    override fun calculateAnswer(input: Input): String {
        return "not implemented"
    }
}
