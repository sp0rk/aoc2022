package aoc7.model

sealed class FileTree(open val name: String) {
    @Suppress("PropertyName")
    var _parent: Directory? = null
    abstract val parent: Directory
    abstract val totalSize: Int
    abstract val allFilesRecursive: Set<FileTree>
    abstract override fun toString(): String

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + (_parent?.hashCode() ?: 0)
        return result
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is FileTree) return false

        if (name != other.name) return false
        if (_parent != other._parent) return false

        return true
    }
}
