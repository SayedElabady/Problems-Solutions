package HackerRank

fun main() {
    val f = arrayOf(1, 2, 100)
    val s = arrayOf(2, 5, 100)
    val t = arrayOf(3, 4, 100)
    arrayManipulation(5, arrayOf(s, f, t))
}

fun arrayManipulation(n: Int, queries: Array<Array<Int>>): Long {

    val ans = MutableList<Long>(n, {0})
    for (i in queries.indices) {
        ans[queries[i][0]] += queries[i][2].toLong()
        ans[queries[i][1] + 1] += queries[i][2].toLong() * -1L
    }
    var max = -1L
    for (i in 1 until ans.size) {
        ans[i] += ans[i - 1]
        max = kotlin.math.max(max, ans[i])
    }
    return max
}
