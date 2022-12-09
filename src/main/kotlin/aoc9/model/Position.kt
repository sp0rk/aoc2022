package aoc9.model

typealias Position = Pair<Int, Int>

operator fun Position.plus(other: Position) = first + other.first to second + other.second
