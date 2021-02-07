import kotlin.math.min

class Solution62 {
    fun uniquePaths(m: Int, n: Int): Int {
        if (m == 1 || n == 1) return 1
        val grid = Array(m) { IntArray(n) }
        for (index in 1 until n) {
            grid[0][index] = 1
        }
        for (index in 1 until m) {
            grid[index][0] = 1
        }
        for (x in 1 until m) {
            for (y in 1 until n) {
                grid[x][y] = grid[x - 1][y] + grid[x][y - 1]
            }
        }
        return grid[m - 1][n - 1]
    }
}