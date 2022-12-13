package aoc13.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.lang.IllegalStateException

@Serializable
data class ListOrInt(
    @SerialName("n")
    val n: Int? = null,
    @SerialName("l")
    val l: List<ListOrInt>? = null,
) {
    val asElement : Element = if (n != null) {
        Element.Number(n)
    } else if (l != null) {
        Element.NestedList(l.map { it.asElement })
    } else {
        throw IllegalStateException("Either n or l has to be present")
    }
}
