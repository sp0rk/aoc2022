package commons

fun <T> Iterable<T>.product(transform: (T) -> Int) = fold(1) { acc, item ->
    acc * transform(item)
}
fun Iterable<Int>.product() = fold(1) { acc, item ->
    acc * item
}

fun Iterable<Long>.product() = fold(1L) { acc, item ->
    acc * item
}

fun Iterable<Double>.product() = fold(1.0) { acc, item ->
    acc * item
}
