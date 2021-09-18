import kotlin.math.max
import kotlin.math.min

fun main() {
    val sol = Solution931()
    val firstRow = intArrayOf(1, 2, 3)
    val secondRow = intArrayOf(4, 5, 6)
    val thirdRow = intArrayOf(7, 8, 9)
    val fourthRow = intArrayOf(1, 0, 1, 0)
    sol.minFallingPathSum(arrayOf(firstRow, secondRow, thirdRow))

}

class Solution931 {
    fun minFallingPathSum(A: Array<IntArray>): Int {
        val visited = Array(A.size) { IntArray(A[0].size) { Int.MAX_VALUE } }
        var ans = Int.MAX_VALUE
        for (i in 0 until A[0].size) {
            visited[0][i] = get(A, 0, i, A[0].size-1, A.size-1, visited)
            ans = min(visited[0][i], ans)
        }
        return ans
    }


    fun get(matrix: Array<IntArray>, x: Int, y: Int, maxRow: Int, maxColumn: Int, visited: Array<IntArray>): Int {
        if (visited[x][y] != Int.MAX_VALUE) return visited[x][y]
        if (x == maxColumn) return matrix[x][y]
        var min = Int.MAX_VALUE
        if (y > 0)
            min = min(matrix[x][y] + get(matrix, x + 1, y - 1, maxRow, maxColumn, visited), min)
        if (y < maxRow)
            min = min(matrix[x][y] + get(matrix, x + 1, y + 1, maxRow, maxColumn, visited), min)
        min = min(matrix[x][y] + get(matrix, x + 1, y, maxRow, maxColumn, visited), min)
        visited[x][y] = min
        return min
    }

}