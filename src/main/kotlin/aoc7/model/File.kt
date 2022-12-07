package aoc7.model

data class File(override val name: String, val size: Int) : FileTree(name) {
    override val parent
        get() = _parent!!

    override val totalSize = size
    override val allFilesRecursive = listOf(this)

    override fun toString() = "$name (size: $size)"
}
