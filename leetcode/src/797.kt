fun main() {
    val sol = Solutions797()
    val first = intArrayOf(1, 2)
    val second = intArrayOf(3)
    val third = intArrayOf(3)
    val forth = intArrayOf()

  println(sol.allPathsSourceTarget(arrayOf(first, second, third, forth)))
}

class Solutions797 {
    val ans: MutableList<List<Int>> = mutableListOf()
    fun allPathsSourceTarget(graph: Array<IntArray>): List<List<Int>> {
        get(graph, 0, listOf(0), graph.size - 1)
        return ans
    }

    fun get(graph: Array<IntArray>, curr: Int, listTillNow: List<Int>, n: Int) {
        for (i in 0 until graph[curr].size) {
            val copy = listTillNow.copy().toMutableList()
            copy.add(graph[curr][i])
            if (curr == n - 1) ans.add(copy)
            else get(graph, graph[curr][i], copy, n)
        }
        if(graph[curr].size == 0) ans.add(listTillNow)
    }

    fun <T> List<T>.copy(): List<T> {
        val ret = mutableListOf<T>()
        for (i in 0 until this.size)
            ret.add(this[i])
        return ret.toList()
    }
}