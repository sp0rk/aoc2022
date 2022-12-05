package core

import java.io.IOException

object FileReader {
    fun readFile(path: String, trim: Boolean = true): String {
        val file = {}.javaClass.getResource(path)

        return file?.readText()?.run {
            if (trim) {
                trim()
            } else {
                this
            }
        } ?: throw IOException("File at $path does not exist")
    }
}
