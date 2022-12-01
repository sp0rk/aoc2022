package core

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

abstract class AocTest(
    private val testInput: String,
    private val expectedOutput: String,
    private val sut: Aoc
) {

    @Test
    fun test() {
        assertEquals(expectedOutput, sut.calculateAnswer(testInput))
    }
}