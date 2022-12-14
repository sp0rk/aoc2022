package commons

interface Positional<T> {
    operator fun get(key: Position) : T?

    fun upFrom(position: Position): Position?

    fun downFrom(position: Position): Position?

    fun rightFrom(position: Position): Position?

    fun leftFrom(position: Position): Position?
}
