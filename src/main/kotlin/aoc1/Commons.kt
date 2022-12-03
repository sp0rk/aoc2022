package aoc1

import core.Input

object Commons {
    fun calculateCalorieSums(input: Input): List<Int> {
        val elves = input.split("\n\n")
        val foodsItemsPerElf = elves.map { elf ->
            elf.split("\n")
        }
        val calorieSums = foodsItemsPerElf.map { foodItems ->
            val caloriesPerFoodItem = foodItems.map(String::toInt)

            caloriesPerFoodItem.sum()
        }
        return calorieSums
    }
}
