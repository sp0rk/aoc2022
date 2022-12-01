package com.github.spork.aoc2022.core

import java.io.IOException

object FileReader {
    fun readFile(path: String): String {
        val file = {}.javaClass.getResource(path)

        return file?.readText() ?: throw IOException("File at $path does not exist")
    }
}