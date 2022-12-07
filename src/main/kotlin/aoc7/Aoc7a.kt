package aoc7

import aoc7.Aoc7a.FileTree.Directory
import aoc7.Aoc7a.FileTree.Directory.Root
import aoc7.Aoc7a.FileTree.File
import core.Aoc
import core.Input
import java.util.*

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
        val fileTree = constructFileTreeFromCommands(input.lineStrings)
        println (fileTree)
        return "not implemented"
    }

    private fun constructFileTreeFromCommands(commands: List<String>): FileTree {
        var workingDirectory: Directory = Root
        val LS_PATTERN = "ls"
        val CD_PATTERN = "\\$ cd (.+)"
        val FILE_PATTERN = "(\\d+) (.+)"
        val DIRECTORY_PATTERN = "dir (.+)"

        fun handleCd(command: String) {
            val (name) = Regex(CD_PATTERN).matchEntire(command)!!.destructured
            workingDirectory = if (name == "..") {
                workingDirectory.parent
            } else {
                workingDirectory[name]
            }
        }

        fun handleFile(command: String) {
            val (size, name) = Regex(FILE_PATTERN).matchEntire(command)!!.destructured
            workingDirectory.addChild(File(name, size.toInt()))
        }

        fun handleDirectory(command: String) {
            val (name) = Regex(DIRECTORY_PATTERN).matchEntire(command)!!.destructured
            workingDirectory.addChild(Directory(name))
        }


        commands
            // First line is always `$ cd /` which we've already initialized
            .drop(1)
            .forEach { command ->
                when {
                    command.matches(Regex(CD_PATTERN)) -> handleCd(command)
                    command.matches(Regex(FILE_PATTERN)) -> handleFile(command)
                    command.matches(Regex(DIRECTORY_PATTERN)) -> handleDirectory(command)
                    command.matches(Regex(LS_PATTERN)) -> {
                        /** noop **/
                    }

                    else -> {
                        throw IllegalArgumentException("Cannot parse command $command")
                    }
                }
            }

        while (workingDirectory !is Root) {
            workingDirectory = workingDirectory.parent
        }

        return workingDirectory
    }

    sealed class FileTree(open val name: String) {
        protected var _parent: Directory? = null
        abstract val parent: Directory
        abstract val totalSize: Int

        open class Directory(override val name: String) : FileTree(name) {
            private val children = TreeSet<FileTree>()

            override val parent
                get() = _parent!!

            override val totalSize: Int
                get() = children.sumOf(FileTree::totalSize)

            operator fun get(name: String) = children
                .filterIsInstance<Directory>()
                .first { it.name == name }

            fun addChild(child: FileTree) {
                child._parent = this
                children.add(child)
            }


            object Root : Directory("") {
                override val parent: Directory
                    get() = throw IllegalStateException("Root does not have a parent")
                override val totalSize: Int
                    get() = throw IllegalStateException("Root does not have a size")
            }
        }

        data class File(override val name: String, val size: Int) : FileTree(name) {
            override val parent
                get() = _parent!!

            override val totalSize = size
        }
    }


}
