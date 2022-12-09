package core

import com.google.common.truth.Truth.assertThat
import kotlin.test.Test

abstract class AocTest(
    private val sut: Aoc,
    private vararg val definitions: Pair<String, String>,
) {
    constructor(
        testInput: String,
        expectedOutput: String,
        sut: Aoc
    ) : this(sut, testInput to expectedOutput)

    @Test
    fun test() {
        definitions.forEachIndexed { index, (input, output) ->
            println("Test case #(${index+1}/${definitions.size})")
            assertThat(sut.calculateAnswer(Input(input))).isEqualTo(output)
        }
    }
}
