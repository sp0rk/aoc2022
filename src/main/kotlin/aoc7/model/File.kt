package aoc7.model

class File(override val name: String, private val size: Int) : FileTree(name) {
    override val parent
        get() = _parent!!

    override val totalSize = size
    override val allFilesRecursive = setOf(this)

    override fun toString() = "$name (size: $size)"
}
