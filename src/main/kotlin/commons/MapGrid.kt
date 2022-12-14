package commons

class MapGrid<T: Any>(private val initial: MutableMap<Position, T>) : MutableMap<Position, T> by initial, Positional<T> {

    private var floor = Int.MAX_VALUE
    private lateinit var tileForFloor: T

    override fun get(key: Position) = if(key.y >= floor) {
        tileForFloor
    } else {
        initial[key]
    }

    override fun upFrom(position: Position) =
        position + (0 to -1)

    override fun downFrom(position: Position) =
        position + (0 to 1)

    override fun rightFrom(position: Position) =
        position + (1 to 0)

    override fun leftFrom(position: Position) =
        position + (-1 to 0)

    fun addFloorBelowMaxY(maxY: Int, tileForFloor: T) {
        floor = maxY + 2
        this.tileForFloor = tileForFloor
    }
}
