package commons

typealias Position = Pair<Int, Int>

val Position.x get() = first
val Position.y get() = second

operator fun Position.plus(other: Position) = x + other.x to y + other.y

// e.g. "123, 321"
fun positionFromString(string: String): Position = string.split(",").let { (first, second) ->
    first.toInt() to second.toInt()
}


