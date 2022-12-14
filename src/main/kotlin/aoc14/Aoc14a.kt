package aoc14

import aoc14.model.Commons.asString
import aoc14.model.Commons.nextSandPosition
import aoc14.model.Commons.parseCave
import aoc14.model.Tile
import commons.Position
import core.Aoc
import core.Input

object Aoc14a : Aoc {
    override val inputPath = "/inputs/Aoc14.txt"

    override fun calculateAnswer(input: Input): String {
        val cave = parseCave(input.lineStrings)
        val source: Position = cave.findElement(Tile.SOURCE)

        var currentSandPosition: Position? = source
        var sandSpawned = 0

        while (currentSandPosition != null) {
            // spawn sand
            var previousSandPosition: Position?
            currentSandPosition = source
            do {
                previousSandPosition = currentSandPosition
                currentSandPosition = cave.nextSandPosition(currentSandPosition!!)
            } while (currentSandPosition != null && currentSandPosition != previousSandPosition)

            currentSandPosition?.let {
                cave[currentSandPosition] = Tile.SAND
                sandSpawned++
            }
        }


        return "$sandSpawned"
    }


}
