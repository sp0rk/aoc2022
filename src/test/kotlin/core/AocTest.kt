package core

import com.google.common.truth.Truth.assertThat
import kotlin.test.Test

abstract class AocTest(
    private val testInput: String,
    private val expectedOutput: String,
    private val sut: Aoc
) {

    @Test
    fun test() {
        assertThat(sut.calculateAnswer(testInput)).isEqualTo(expectedOutput)
    }
}