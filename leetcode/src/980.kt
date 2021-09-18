class Solution980 {
    var answer = 0
    var requiredCount = 0
    var start = Pair(0, 0)
    fun uniquePathsIII(grid: Array<IntArray>): Int {
        grid.forEachIndexed { x, it ->
            it.forEachIndexed { y, element ->
                if (element == 0) requiredCount++
                if (element == 1) {
                    start = Pair(x, y)
                }   
            }
        }
        traverse(start.first, start.second, grid, Array(grid.size) { IntArray(grid[0].size) }, 0)
        return answer
    }

    fun traverse(x: Int, y: Int, grid: Array<IntArray>, visited: Array<IntArray>, count: Int) {
        if (grid[x][y] == 2) {
            if (count - 1 == requiredCount) answer++
            return
        }
        if (visited[x][y] == 1) return
        visited[x][y] = 1
        if (x + 1 < grid.size && grid[x + 1][y] != -1) traverse(x + 1, y, grid, visited.copy(), count + 1)
        if (x - 1 >= 0 && grid[x - 1][y] != -1) traverse(x - 1, y, grid, visited.copy(), count + 1)
        if (y + 1 < grid[0].size && grid[x][y + 1] != -1) traverse(x, y + 1, grid, visited.copy(), count + 1)
        if (y - 1 >= 0 && grid[x][y - 1] != -1) traverse(x, y - 1, grid, visited.copy(), count + 1)

    }

    fun Array<IntArray>.copy(): Array<IntArray> {
        val ret = Array(this.size) { IntArray(this[0].size) }
        this.forEachIndexed { x, ints ->
            ints.forEachIndexed { y, element ->
                ret[x][y] = element
            }
        }
        return ret
    }

}

fun main() {
    val s = Solution980()
    // println(s.uniquePathsIII(arrayOf(intArrayOf(1, 0, 0, 0), intArrayOf(0, 0, 0, 0), intArrayOf(0, 0, 2, -1))))

    // println(s.uniquePathsIII(arrayOf(intArrayOf(1, 0, 0, 0), intArrayOf(0, 0, 0, 0), intArrayOf(0, 0, 0, 2))))
    println(s.uniquePathsIII(arrayOf(intArrayOf(0, 1), intArrayOf(2, 0))))

}