package core

import core.FileReader.readFile

interface Aoc {
    val inputPath: String
    fun calculateAnswer(input: Input): String

    operator fun invoke() {
        val input = Input(readFile(inputPath))
        val answer = calculateAnswer(input)
        val aocName = this::class.java.simpleName
        println("$aocName: $answer")
    }
}
