package HackerRank

fun main() {
    rotLeft(arrayOf(1, 2, 3, 4, 5), 4).forEach {
        println(it)
    }
}

fun rotLeft(a: Array<Int>, d: Int): Array<Int> {
    val N = a.size
    val ans = Array<Int>(a.size) { 0 }
    for (i in a.indices) {
        val newIndex = (N - d + i) % N
        ans[newIndex] = a[i]
    }
    return ans
}
