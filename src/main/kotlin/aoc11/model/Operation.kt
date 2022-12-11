package aoc11.model

sealed class Operation(protected open val operands: Pair<Operand, Operand>) {
    data class Plus(override val operands: Pair<Operand, Operand>) : Operation(operands) {
        override fun invoke(old: Int) = operands.first(old) + operands.second(old)
    }

    data class Times(override val operands: Pair<Operand, Operand>) : Operation(operands) {
        override fun invoke(old: Int) = operands.first(old) * operands.second(old)
    }

    abstract operator fun invoke(old: Int): Int

    companion object {
        fun of(firstOperand: String, operator: String, secondOperand: String) = when (operator) {
            "+" -> Plus(Operand.of(firstOperand) to Operand.of(secondOperand))
            "*" -> Times(Operand.of(firstOperand) to Operand.of(secondOperand))
            else -> throw IllegalArgumentException("$operator is not a valid operator.")
        }
    }
}
