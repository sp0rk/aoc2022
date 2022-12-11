package aoc11.model

data class Monkey(
    val items: MutableList<Long>,
    val operation: Operation,
    val divider: Int,
    val trueTarget: Int,
    val falseTarget: Int
) {
    var monkeyBusinessFactor= 0L
}
