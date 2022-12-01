package core

import com.google.common.truth.Truth.assertThat
import core.FileReader.readFile
import org.junit.Assert.assertThrows
import java.io.IOException
import kotlin.test.Test

class FileReaderTest {
    @Test
    fun `GIVEN file exists WHEN read file THEN return file contents`() {
        val path = "/TestFile.txt"
        val expected =
            """
            4852
            4512
            
            4277
            3324
            """.trimIndent()

        val actual = readFile(path)

        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `GIVEN file exists AND has leading or trailing whitespace WHEN read file THEN return file contents trimmed`() {
        val path = "/TestFileUnsanitised.txt"
        val expected =
            """
            4852
            4512
            
            4277
            3324
            """.trimIndent()

        val actual = readFile(path)

        assertThat(actual).isEqualTo(expected)
    }

    @Test
    fun `GIVEN file does not exist WHEN read file THEN throw`() {
        val path = "/NonExistentFile.txt"

        assertThrows(IOException::class.java) {
            readFile(path)
        }
    }
}
