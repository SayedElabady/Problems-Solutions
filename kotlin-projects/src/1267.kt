class Solution1267 {
    val visited = Array(251) { BooleanArray(251) }
    fun countServers(grid: Array<IntArray>): Int {
        var answer = 0
        grid.forEachIndexed { x, xs ->
            xs.forEachIndexed { y, ys ->
                if (!visited[x][y] && grid[x][y] == 1) {
                    val group = traverse(x, y, grid)
                    if (group > 1)
                        answer += group
                }
            }
        }
        return answer
    }

    fun traverse(x: Int, y: Int, grid: Array<IntArray>): Int {
        var _count = 1
        visited[x][y] = true
        for (X in 0 until grid.size) {
            if (grid[X][y] == 1 && !visited[X][y]) _count += traverse(X, y, grid)
        }
        for (Y in 0 until grid[x].size){
            if (grid[x][Y] == 1 && !visited[x][Y]) _count += traverse(x, Y, grid)
        }
        return _count
    }
}

fun main() {
    val s = Solution1267()
    println(s.countServers(arrayOf(intArrayOf(1, 0), intArrayOf(1, 1))))
    println(s.countServers(arrayOf(intArrayOf(1, 0), intArrayOf(0, 1))))

}