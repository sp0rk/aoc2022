package core

import core.FileReader.readFile

interface Aoc {
    val inputPath: String
    fun calculateAnswer(input: Input): String
    fun shouldTrimInput() = true

    operator fun invoke() {
        val input = Input(readFile(inputPath, trim = shouldTrimInput()))
        val answer = calculateAnswer(input)
        val aocName = this::class.java.simpleName
        println("$aocName: $answer")
    }
}
