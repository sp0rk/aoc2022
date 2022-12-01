package core

import core.FileReader.readFile

interface Aoc {
    val inputPath: String
    fun calculateAnswer(input: String): String

    operator fun invoke() {
        val input = readFile(inputPath)
        val answer = calculateAnswer(input)
        val aocName = this::class.java.simpleName
        println("$aocName: $answer")
    }
}