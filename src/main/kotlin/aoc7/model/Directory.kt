package aoc7.model

open class Directory(override val name: String) : FileTree(name) {
    private val children = HashSet<FileTree>()

    override val parent
        get() = _parent!!

    override val totalSize: Int
        get() = children.sumOf(FileTree::totalSize)

    operator fun get(name: String) = children
        .filterIsInstance<Directory>()
        .first { it.name == name }

    fun addChild(child: FileTree) {
        child._parent = this
        children.add(child)
    }

    override fun toString() = buildString {
        appendLine("$name:")
        children
            .map(FileTree::toString)
            .flatMap(String::lines)
            .forEach { child ->
                appendLine("\t$child")
            }
    }
}
