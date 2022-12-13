package aoc13

import aoc13.Commons.parsePairs
import aoc13.model.Element
import commons.product
import core.Aoc
import core.Input

object Aoc13b : Aoc {
    override val inputPath = "/inputs/Aoc13.txt"

    override fun calculateAnswer(input: Input): String {
        val pairs = parsePairs(input.paragraphs)

        val dividerElements = listOf(
            makeDividerElement(2),
            makeDividerElement(6)
        )

        val allElements = pairs
            .map(Pair<Element, Element>::toList)
            .flatten() + dividerElements

        val sortedElements = allElements.sorted()

        val productOfDividerElements = dividerElements
            .map { dividerElement ->
                sortedElements.indexOf(dividerElement)
            }
            .product { index ->
                index + 1
            }

        return "$productOfDividerElements"
    }

    private fun makeDividerElement(value: Int) = Element.NestedList(
        listOf(
            Element.NestedList(
                listOf(
                    Element.Number(value)
                )
            )
        )
    )
}

