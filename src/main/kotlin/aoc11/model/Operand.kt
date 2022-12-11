package aoc11.model

sealed interface Operand {
    object Old : Operand {
        override fun invoke(old: Int) = old
    }

    data class Number(val number: Int) : Operand {
        override fun invoke(old: Int) = number
    }

    operator fun invoke(old: Int): Int

    companion object {
        fun of(operand: String) = when (operand) {
            "old" -> Old
            else -> Number(operand.toInt())
        }
    }
}
