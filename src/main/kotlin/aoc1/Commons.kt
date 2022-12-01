package aoc1

object Commons {
    fun calculateCalorieSums(input: String): List<Int> {
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
