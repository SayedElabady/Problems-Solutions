package HackerRank

fun firstOccurrence(s: String, x: String): Int {
    s.forEachIndexed { index, c ->
        if (index > s.length - x.length) return -1
        if (c == x[0])
            if (check(x, s.substring(index, index + x.length)))
                return index
    }
    return -1
}

fun check(a: String, b: String): Boolean {
    if (a.length != b.length) return false
    a.forEachIndexed { index, c ->
        if (c != b[index] && a[index] != '*') return false
    }
    return true
}

fun main(args: Array<String>) {
    val s = readLine()!!

    val x = readLine()!!

    val result = firstOccurrence(s, x)

    println(result)
}
