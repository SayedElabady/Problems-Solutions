class Solution1020 {
    fun numEnclaves(A: Array<IntArray>): Int {
        val visited = Array(A.size) { BooleanArray(A[0].size) }
        var ans = 0
        A.forEachIndexed { x, it ->
            it.forEachIndexed { y, element ->
                if (element == 1 && !visited[x][y]) {
                    val group = traverse(x, y, A, visited)
                    if (!group.second) ans += group.first
                }
            }
        }
        return ans
    }

    fun traverse(
        x: Int,
        y: Int,
        map: Array<IntArray>,
        visitedMap: Array<BooleanArray>
    ): Pair<Int, Boolean> {
        visitedMap[x][y] = true
        var _count = 1
        var _visitedBoundary = x == 0 || x == map.size - 1 || y == 0 || y == map[0].size - 1
        if (x > 0 && map[x - 1][y] == 1 && !visitedMap[x - 1][y]) {
            val group = traverse(x - 1, y,  map, visitedMap)
            _count += group.first
            _visitedBoundary = _visitedBoundary.or(group.second)

        }
        if (x < map.size - 1 && map[x + 1][y] == 1 && !visitedMap[x + 1][y]) {
            val group = traverse(x + 1, y,  map, visitedMap)
            _count += group.first
            _visitedBoundary = _visitedBoundary.or(group.second)

        }
        if (y > 0 && map[x][y - 1] == 1 && !visitedMap[x][y - 1]) {
            val group = traverse(x, y - 1,  map, visitedMap)
            _count += group.first
            _visitedBoundary = _visitedBoundary.or(group.second)

        }
        if (y < map[0].size - 1 && map[x][y + 1] == 1 && !visitedMap[x][y + 1]) {
            val group = traverse(x, y + 1, map, visitedMap)
            _count += group.first
            _visitedBoundary = _visitedBoundary.or(group.second)

        }

        return Pair(_count, _visitedBoundary)
    }
}

fun main() {
    val s = Solution1020()
    println(
        s.numEnclaves(
            arrayOf(
                intArrayOf(0, 0, 0, 0),
                intArrayOf(1, 0, 1, 0),
                intArrayOf(0, 1, 1, 0),
                intArrayOf(0, 0, 0, 0)
            )
        )
    )
    println(
        s.numEnclaves(
            arrayOf(
                intArrayOf(0, 1, 1, 0),
                intArrayOf(0, 0, 1, 0),
                intArrayOf(0, 0, 1, 0),
                intArrayOf(0, 0, 0, 0)
            )
        )
    )

}