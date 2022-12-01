package core

import com.github.spork.aoc2022.core.FileReader.readFile
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.io.IOException

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

        assertEquals(expected, actual)
    }

    @Test
    fun `GIVEN file does not exist WHEN read file THEN throw`() {
        val path = "/NonExistentFile.txt"

        assertThrows<IOException> {
            readFile(path)
        }
    }
}