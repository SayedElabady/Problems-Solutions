fun main() {
    val firstRow = intArrayOf(0, 1, 1, 1)
    val secondRow = intArrayOf(1, 1, 0, 1)
    val thirdRow = intArrayOf(1, 1, 1, 1)
    val fourthRow = intArrayOf(1, 0, 1, 0)
    val sol = Solution1277()

    println(sol.countSquares(arrayOf(firstRow, secondRow, thirdRow)))
}

class Solution1277 {
    var sum = 0
    fun countSquares(matrix: Array<IntArray>): Int {
        val n = matrix.size
        val m = matrix[0].size
        for (x in 0 until n) {
            for (y in 0 until m) {
                check(matrix, x, y, n, m)
            }
        }
        return sum
    }

    fun check(matrix: Array<IntArray>, x: Int, y: Int, n: Int, m: Int) {
        var plus = 0
        while (true) {
            if (x + plus == n || y + plus == m) return
            if (isValidSquare(matrix, x, y, plus))
                sum++
            else return
            plus++
        }
    }

    fun isValidSquare(matrix: Array<IntArray>, x: Int, y: Int, plus: Int): Boolean {
        for (i in x..x + plus)
            if (matrix[i][y] == 0) return false
        for (i in x..x + plus)
            if (matrix[i][y + plus] == 0) return false
        for (i in y..y + plus)
            if (matrix[x][i] == 0) return false
        for (i in y..y + plus)
            if (matrix[x + plus][i] == 0) return false

        if (matrix[x][y] == 1)
            return true
        return false
    }
}