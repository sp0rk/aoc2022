package aoc11.model

data class Monkey(
    val startingItems: MutableList<String>,
    val operation: Operation,
    val divider: Int,
    val trueTarget: Int,
    val falseTarget: Int
)
