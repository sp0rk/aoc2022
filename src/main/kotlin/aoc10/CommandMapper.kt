package aoc10

private const val NOOP_PATTERN = "noop"
private const val ADDX_PATTERN = "addx (-?\\d+)"

object CommandMapper {
    fun constructRegisterHistoryFromCommands(commands: List<String>): List<Int> {
        val xRegister = Register()

        fun handleNoop() {
            xRegister.skipCycle()
        }

        fun handleAddx(command: String) {
            val (x) = Regex(ADDX_PATTERN).matchEntire(command)!!.destructured

            // Takes 2 cycles
            xRegister.skipCycle()
            xRegister.increment(x.toInt())
        }

        commands
            .forEach { command ->
                when {
                    command.matches(Regex(ADDX_PATTERN)) -> handleAddx(command)
                    command.matches(Regex(NOOP_PATTERN)) -> handleNoop()

                    else -> {
                        throw IllegalArgumentException("Cannot parse command $command")
                    }
                }
            }

        return xRegister.value
    }
}
