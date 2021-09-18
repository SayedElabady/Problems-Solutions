class Solution63 {
    fun uniquePathsWithObstacles(obstacleGrid: Array<IntArray>): Int {
        obstacleGrid.forEachIndexed { x, array ->
            array.forEachIndexed { y, item ->
                if (item == 1) obstacleGrid[x][y] = -1
            }
        }
        obstacleGrid[0][0] = 1
        val m = obstacleGrid.size
        if (m < 1) return 0
        val n = obstacleGrid[0].size
        for (index in 1 until n) {
            if (obstacleGrid[0][index - 1] == -1) obstacleGrid[0][index] = -1
            else if (obstacleGrid[0][index] == 0) obstacleGrid[0][index] = 1
        }
        for (index in 1 until m) {
            if (obstacleGrid[index - 1][0] == -1) obstacleGrid[index][0] = -1
            else if (obstacleGrid[index][0] == 0) obstacleGrid[index][0] = 1
        }
        for (x in 1 until m) {
            for (y in 1 until n) {
                if (obstacleGrid[x][y] == -1) continue
                obstacleGrid[x][y] = when {
                    obstacleGrid[x - 1][y] == -1 -> obstacleGrid[x][y - 1]
                    obstacleGrid[x][y - 1] == -1 -> obstacleGrid[x - 1][y]
                    else -> obstacleGrid[x - 1][y] + obstacleGrid[x][y - 1]
                }
            }
        }

        return Math.max(obstacleGrid[m - 1][n - 1], 0)
    }
}

fun main() {
    val s = Solution63()
    s.uniquePathsWithObstacles(arrayOf(intArrayOf(0, 0, 0), intArrayOf(0, 1, 0), intArrayOf(0, 0, 0)))
}