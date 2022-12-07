package aoc7.model

sealed class FileTree(open val name: String) {
    @Suppress("PropertyName")
    var _parent: Directory? = null
    abstract val parent: Directory
    abstract val totalSize: Int
    abstract val allFilesRecursive: List<FileTree>
    abstract override fun toString(): String
}
