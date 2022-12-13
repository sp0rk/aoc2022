package aoc13

import aoc13.model.ListOrInt
import core.Aoc
import core.Input
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

object Aoc13a : Aoc {
    override val inputPath = "/inputs/Aoc13.txt"

    override fun calculateAnswer(input: Input): String {
        val pairs = parsePairs(input.paragraphs)



        return "not implemented"
    }

    private fun parsePairs(pairs: List<Input>) =
        pairs
            .map(Input::lineStrings)
            .map { pairString ->
                val pair = pairString.map { list ->
                    Json.decodeFromString<ListOrInt>(expandToJson(list)).asElement
                }
                pair[0] to pair[1]
            }

    private fun expandToJson(original: String): String {
        val wNums = original.replace(Regex("[0-9]+")) {
            val number = it.groupValues[0]
            "{\"n\":$number}"
        }
        val wOpens = wNums.replace(Regex("\\[")) {
            "{\"l\":["
        }
        val wCloses = wOpens.replace(Regex("\\]")) {
            "]}"
        }
        return wCloses
    }
}

