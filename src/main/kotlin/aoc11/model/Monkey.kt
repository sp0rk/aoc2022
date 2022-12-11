package aoc11.model

data class Monkey(
    val items: MutableList<Int>,
    val operation: Operation,
    val divider: Int,
    val trueTarget: Int,
    val falseTarget: Int
) {
    var monkeyBusinessFactor: Int = 0
}
