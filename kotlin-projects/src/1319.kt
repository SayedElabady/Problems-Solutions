class Solution1319 {
    fun makeConnected(n: Int, connections: Array<IntArray>): Int {
        if (connections.size < n - 1) return -1
        val visited = BooleanArray(n)
        val map = Array<MutableList<Int>>(n) { mutableListOf() }
        connections.forEach {
            map[it[0]].add(it[1])
            map[it[1]].add(it[0])
        }
        var connectedComponents = 0
        for (node in 0 until n) {
            if (!visited[node]) {
                traverse(map, visited, node)
                connectedComponents++
            }
        }
        return connectedComponents - 1
    }

    fun traverse(map: Array<MutableList<Int>>, visited: BooleanArray, node: Int) {
        if (visited[node]) return
        visited[node] = true
        for (i in map[node]) {
            if (!visited[i]) traverse(map, visited, i)
        }
    }
}

fun main() {
    val s = Solution1319()
    println(
        s.makeConnected(
            6,
            arrayOf(intArrayOf(0, 1), intArrayOf(0, 2), intArrayOf(0, 3), intArrayOf(1, 2), intArrayOf(1, 3))
        )
    )
    println(
        s.makeConnected(
            4,
            arrayOf(intArrayOf(0, 1), intArrayOf(0, 2), intArrayOf(1, 2))
        )
    )
    println(
        s.makeConnected(
            5,
            arrayOf(intArrayOf(0, 1), intArrayOf(0, 2), intArrayOf(3, 4), intArrayOf(2,3))
        )
    )
}