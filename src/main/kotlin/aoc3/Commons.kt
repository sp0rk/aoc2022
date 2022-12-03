package aoc3

private const val LOWERCASE_A_CODE = 97
private const val UPPERCASE_OFFSET = 26

object Commons {
    fun calculateItemPriority(item: Char): Int {
        val offsetFromA = item.lowercaseChar().code - LOWERCASE_A_CODE // B=1
        val lowercasePriority = offsetFromA + 1 // B=2
        val caseOffset = if (item.isUpperCase()) { // B=26
            UPPERCASE_OFFSET
        } else {
            0
        }

        return lowercasePriority + caseOffset // B=28
    }
}
