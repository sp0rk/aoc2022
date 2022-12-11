package aoc11

import aoc11.model.Monkey
import aoc11.model.Operation
import core.Aoc
import core.Input

object Aoc11a : Aoc {
    override val inputPath = "/inputs/Aoc11.txt"

    override fun calculateAnswer(input: Input): String {
        val monkeys = parseMonkeys(input.paragraphs)

        return "not implemented"
    }

    private fun parseMonkeys(paragraphs: List<Input>) = paragraphs.map { paragraph ->
        parseMonkey(paragraph.lineStrings)
    }

    /**
     * @param monkey is 6 one-line strings as follows:
     * Monkey 0:
     *   Starting items: 75, 75, 98, 97, 79, 97, 64
     *   Operation: new = old * 13
     *   Test: divisible by 19
     *     If true: throw to monkey 2
     *     If false: throw to monkey 7
     */
    private fun parseMonkey(monkey: List<String>): Monkey {
        // monkey[0]: noop
        // monkey[1]: 75, 75, 98, 97, 79, 97, 64
        val (startingItemsRaw) = Regex("Starting items: (\\d.*)").matchEntire(monkey[1])!!.destructured
        val startingItems = startingItemsRaw.split(", ").toMutableList()

        // monkey[2]: old * 13
        val (firstOperand, operator, secondOperand) =
            Regex("Operation: new = (\\w+) ([*+]) (\\w+)").matchEntire(monkey[2])!!.destructured
        val operation = Operation.of(firstOperand, operator, secondOperand)

        // monkey[3]: 19
        val (dividerRaw) = Regex("Test: divisible by (\\d+)").matchEntire(monkey[3])!!.destructured
        val divider = dividerRaw.toInt()

        val targetPattern = Regex("If \\w+: throw to monkey (\\d+)")
        // monkey[4]: 2
        val (trueTargetRaw) = targetPattern.matchEntire(monkey[4])!!.destructured
        val trueTarget = trueTargetRaw.toInt()

        // monkey[5]: 7
        val (falseTargetRaw) = targetPattern.matchEntire(monkey[5])!!.destructured
        val falseTarget = falseTargetRaw.toInt()

        return Monkey(startingItems, operation, divider, trueTarget, falseTarget)
    }


}
