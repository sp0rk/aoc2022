package aoc7

import aoc7.FileTreeCommandMapper.constructFileTreeFromCommands
import aoc7.model.Directory
import aoc7.model.FileTree
import core.Aoc
import core.Input

/**
 * Day 7: No Space Left On Device Part Two
 * https://adventofcode.com/2022/day/7
 *
 * The total disk space available to the filesystem is 70_000_000.
 * To run the update, you need unused space of at least 30_000_000.
 *
 * Find the smallest directory that, if deleted, would free up enough space on the filesystem to run the update.
 * What is the total size of that directory?
 */
object Aoc7b : Aoc {
    override val inputPath = "/inputs/Aoc7.txt"

    override fun calculateAnswer(input: Input): String {
        val fileTree = constructFileTreeFromCommands(input.lineStrings)
        val freeSpace = TOTAL_DISK_SPACE - fileTree.totalSize
        val missingSpace = REQUIRED_DISK_SPACE - freeSpace

        val candidatesForDeletion = findAllDirectoriesNoSmallerThan(fileTree, missingSpace)
        val smallestCandidate = candidatesForDeletion.minBy(FileTree::totalSize).totalSize

        return "$smallestCandidate"
    }

    private fun findAllDirectoriesNoSmallerThan(fileTree: FileTree, threshold: Int) = fileTree
        .allFilesRecursive
        .filterIsInstance<Directory>()
        .filter { it.totalSize >= threshold }
}

private const val TOTAL_DISK_SPACE = 70_000_000
private const val REQUIRED_DISK_SPACE = 30_000_000
