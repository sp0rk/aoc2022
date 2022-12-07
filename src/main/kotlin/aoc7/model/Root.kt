package aoc7.model

object Root : Directory("/") {
    override val parent: Directory
        get() = throw IllegalStateException("Root does not have a parent")
}
