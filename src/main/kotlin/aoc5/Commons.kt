package aoc5

/**
 * @param 2D list of values
 * e.g.
 * [
 *  [A,B,C],
 *  [0,1,2],
 *  [X,Y,Z]
 * ]
 *
 * @return 2D list of same values with rows, and columns swapped
 * e.g.
 * [
 *  [A,0,X],
 *  [B,1,Y],
 *  [C,2,Z]
 * ]
 */
fun <T> transpose(list: List<List<T>>): List<List<T>> {
    val transposedListSize = list.first().size
    val transposedList = buildList<MutableList<T>> { repeat(transposedListSize) { add(mutableListOf()) } }

    list.forEach { sublist ->
        sublist.forEachIndexed { index, item ->
            transposedList[index].add(item)
        }
    }

    return transposedList
}
