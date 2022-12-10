package aoc10

@JvmInline
value class Register(val value: MutableList<Int> = mutableListOf(1)) {
    // Duplicate last element
    fun skipCycle() = value.add(value.last())

    // Add by to last element
    fun increment(by: Int) = value.add(value.last() + by)
}
