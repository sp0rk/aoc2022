package aoc1

import core.Input

object Commons {
    fun calculateCalorieSums(input: Input): List<Int> {
        val elves = input.paragraphs
        val foodsItemsPerElf = elves.map { elf ->
            elf.lineStrings
        }
        val calorieSums = foodsItemsPerElf.map { foodItems ->
            val caloriesPerFoodItem = foodItems.map(String::toInt)

            caloriesPerFoodItem.sum()
        }
        return calorieSums
    }
}
