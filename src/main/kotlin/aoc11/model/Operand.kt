package aoc11.model

sealed interface Operand {
        object Old : Operand
        data class Number(val number: Int) : Operand

        companion object {
            fun of(operand: String) = when (operand) {
                "old" -> Old
                else -> Number(operand.toInt())
            }
        }
    }
