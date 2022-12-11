package aoc11

import aoc11.model.Monkey
import aoc11.model.Operation
import core.Aoc
import core.Input

object Aoc11a : Aoc {
    override val inputPath = "/inputs/Aoc11.txt"

    override fun calculateAnswer(input: Input): String {
        val monkeys = parseMonkeys(input.paragraphs)

        repeat(20) {
            playRound(monkeys)
        }

        val monkeyBusinessLevel = monkeys
            .map(Monkey::monkeyBusinessFactor)
            .sortedDescending()
            .take(2)
            .reduce { acc, i -> acc * i }

        return "$monkeyBusinessLevel"
    }

    private fun playRound(monkeys: List<Monkey>) {
        monkeys.forEach { monkey ->
            val targets = mutableListOf<Int>()
            // play a turn
            monkey.items.toList().forEachIndexed { index, item ->
                // inspect item
                monkey.items[index] = monkey.operation(item) / 3
                monkey.monkeyBusinessFactor++

                // choose target
                targets += if (monkey.items[index] % monkey.divider == 0) {
                    monkey.trueTarget
                } else {
                    monkey.falseTarget
                }
            }

            // throw item to target
            targets.zip(monkey.items) { targetIndex, item ->
                monkeys[targetIndex].items.add(item)
            }
            // all items were thrown
            monkey.items.clear()
        }
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
        val (startingItemsRaw) = Regex("\\s*Starting items: (\\d.*)").matchEntire(monkey[1])!!.destructured
        val startingItems = startingItemsRaw.split(", ").map(String::toInt).toMutableList()

        // monkey[2]: old * 13
        val (firstOperand, operator, secondOperand) =
            Regex("\\s*Operation: new = (\\w+) ([*+]) (\\w+)").matchEntire(monkey[2])!!.destructured
        val operation = Operation.of(firstOperand, operator, secondOperand)

        // monkey[3]: 19
        val (dividerRaw) = Regex("\\s*Test: divisible by (\\d+)").matchEntire(monkey[3])!!.destructured
        val divider = dividerRaw.toInt()

        val targetPattern = Regex("\\s*If \\w+: throw to monkey (\\d+)")
        // monkey[4]: 2
        val (trueTargetRaw) = targetPattern.matchEntire(monkey[4])!!.destructured
        val trueTarget = trueTargetRaw.toInt()

        // monkey[5]: 7
        val (falseTargetRaw) = targetPattern.matchEntire(monkey[5])!!.destructured
        val falseTarget = falseTargetRaw.toInt()

        return Monkey(startingItems, operation, divider, trueTarget, falseTarget)
    }


}
