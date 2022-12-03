package core

@JvmInline
@Suppress("MemberVisibilityCanBePrivate", "unused")
value class Input(private val value: String) : CharSequence by value {
    val paragraphStrings
        get() = value.split("\n\n")

    val paragraphs
        get() = paragraphStrings.map(::Input)

    val lineStrings
        get() = value.split("\n")

    val lines
        get() = lineStrings.map(::Input)

    val wordStrings
        get() = value.split(" ")

    val words
        get() = wordStrings.map(::Input)
}
