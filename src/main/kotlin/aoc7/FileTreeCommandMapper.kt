package aoc7

import aoc7.model.Directory
import aoc7.model.File
import aoc7.model.FileTree
import aoc7.model.Root

private const val LS_PATTERN = "\\$ ls"
private const val CD_PATTERN = "\\$ cd (.+)"
private const val FILE_PATTERN = "(\\d+) (.+)"
private const val DIRECTORY_PATTERN = "dir (.+)"

object FileTreeCommandMapper {
    fun constructFileTreeFromCommands(commands: List<String>): FileTree {
        // Define tools
        var workingDirectory: Directory = Root

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

        // Build the tree one command at a time
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

        // Go back to root
        while (workingDirectory !is Root) {
            workingDirectory = workingDirectory.parent
        }

        return workingDirectory
    }
}
