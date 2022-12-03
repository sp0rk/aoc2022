package core

@JvmInline
value class Input(private val value: String) : CharSequence by value {
    val lines
        get() = value.split("\n")
}
