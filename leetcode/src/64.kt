import kotlin.math.min

class Solution64 {

    fun minPathSum(grid: Array<IntArray>): Int {
        val m = grid.size
        if(m<1) return 0
        val n = grid[0].size
        for (index in 1 until n) {
            grid[0][index] += grid[0][index - 1]
        }
        for (index in 1 until m) {
            grid[index][0] += grid[index - 1][0]
        }
        for (x in 1 until m) {
            for (y in 1 until n) {
                grid[x][y] += min(grid[x - 1][y], grid[x][y - 1])
            }
        }

        return grid[m - 1][n - 1]
    }

}

fun main() {
    val s = Solution64()
    println(s.minPathSum(arrayOf(intArrayOf(1,2,3), intArrayOf(4,5,6))))
}
