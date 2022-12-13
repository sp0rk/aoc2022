package aoc13.model

sealed class Element : Comparable<Element>{
    data class Number(val value: Int) : Element()
    data class NestedList(val value: List<Element>) : Element()

    override fun compareTo(other: Element): Int = when (this) {
        is Number -> when (other) {
            is Number -> {
                value.compareTo(other.value)
            }
            is NestedList -> {
                NestedList(listOf(Number(value))).compareTo(other)
            }
        }
        is NestedList -> when (other) {
            is Number -> {
                this.compareTo(NestedList(listOf(Number(other.value))))
            }
            is NestedList -> {

            }
        }
    }
}
