package aoc13.model

sealed class Element : Comparable<Element> {
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
                value.compareTo(other.value)
            }
        }
    }

    companion object {
        private tailrec fun List<Element>.compareTo(other: List<Element>): Int = when {
            isEmpty() && other.isEmpty() -> 0
            isEmpty() && other.isNotEmpty() -> -1
            isNotEmpty() && other.isEmpty() -> 1
            else -> {
                val comparison = this[0].compareTo(other[0])
                when {
                    comparison < 0 -> -1
                    comparison > 0 -> 1
                    else -> this.drop(1).compareTo(other.drop(1))
                }
            }
        }
    }
}
