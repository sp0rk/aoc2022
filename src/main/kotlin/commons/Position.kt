package commons

typealias Position = Pair<Int, Int>

val Position.x get() = first
val Position.y get() = second

operator fun Position.plus(other: Position) = x + other.x to y + other.y


