package com.github.spork.aoc2022

import com.github.spork.aoc2022.core.Aoc

object Aoc1a: Aoc {
    override val inputPath = "/inputs/Aoc1a.txt"

    override fun calculateAnswer(input: String) : String {
        val elves = input.split("\n\n")
        val foodsItemsPerElf =  elves.map {elf ->
            elf.split("\n")
        }
        val calorieSums = foodsItemsPerElf.map {foodItems ->
            val caloriesPerFoodItem = foodItems.map(String::toInt)

            caloriesPerFoodItem.sum()
        }
        val maxCaloriesOfAllElves = calorieSums.max()

        return "$maxCaloriesOfAllElves"
    }
}