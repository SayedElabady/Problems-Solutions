class Solution221 {
    fun maximalSquare(matrix: Array<CharArray>): Int {
        val values = Array<IntArray>(matrix.size) { IntArray(matrix[0].size) }
        for (row in 0 until matrix.size) {
            values[row][0] = matrix[row][0].toString().toInt()
        }
        for (row in 0 until matrix.size) {
            for (col in 1 until matrix[0].size) {
                values[row][col] += values[row][col - 1].toString().toInt() + matrix[row][col].toString().toInt()
            }
        }
        var answer = 0
        for (row in 0 until matrix.size) {
            for (col in 0 until matrix[0].size) {
                if (matrix[row][col] == '1') {
                    var square = 2
                    while (true) {
                        if (!canMakeSquareOf(values, row, col, square)) break
                        square++
                    }
                    val newCandidate = (square - 1) * (square - 1)
                    answer = maxOf(answer, maxOf(newCandidate, 1))
                }
            }
        }
        return answer

    }

    fun canMakeSquareOf(matrix: Array<IntArray>, row: Int, col: Int, value: Int): Boolean {
        if (row + value > matrix.size || col + value > matrix[0].size) return false
        for (rowIndex in row until row + value) {
            if (col != 0) {
                if (matrix[rowIndex][col + value - 1] - matrix[rowIndex][col - 1] < value) return false
            } else {
                if (matrix[rowIndex][col + value - 1] < value) return false

            }
        }
        return true
    }

}

fun main() {
    val s = Solution221()
    s.maximalSquare(
        arrayOf(
            charArrayOf('1', '0', '1', '0', '0'),
            charArrayOf('1', '0', '1', '1', '1'),
            charArrayOf('1', '1', '1', '1', '1'),
            charArrayOf('1', '0', '0', '1', '0')
        )
    )
}