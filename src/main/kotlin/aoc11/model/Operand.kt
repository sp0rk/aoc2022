package aoc11.model

sealed interface Operand {
    object Old : Operand {
        override fun invoke(old: Long) = old
    }

    data class Number(val number: Long) : Operand {
        override fun invoke(old: Long) = number
    }

    operator fun invoke(old: Long): Long

    companion object {
        fun of(operand: String) = when (operand) {
            "old" -> Old
            else -> Number(operand.toLong())
        }
    }
}
