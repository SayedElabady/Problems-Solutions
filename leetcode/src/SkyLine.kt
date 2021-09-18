import kotlin.math.max
import kotlin.math.min

fun main() {
    val solution2 = Solution2()
    print(solution2.maxIncreaseKeepingSkyline(Array<IntArray>(4) { it ->
        when (it) {
            0 -> intArrayOf(3, 0, 8, 4)
            1 -> intArrayOf(2, 4, 5, 7)
            2 -> intArrayOf(9, 2, 6, 3)
            else -> intArrayOf(0, 3, 1, 0)
        }
    }))

}

class Solution2 {
    fun maxIncreaseKeepingSkyline(grid: Array<IntArray>): Int {
        var rows = IntArray(grid.size) { i -> 0 }
        var columns = IntArray(grid.size) { i -> 0 }
        for (rowIndex in 0 until grid.size) {
            for (columnIndex in 0 until grid.size) {
                rows[rowIndex] = max(rows[rowIndex], grid[rowIndex][columnIndex])
                columns[columnIndex] = max(columns[columnIndex], grid[rowIndex][columnIndex])
            }
        }

        var sum = 0
        for (rowIndex in 0 until grid.size) {
            for (columnIndex in 0 until grid.size) {
                sum += if (min(
                        rows[rowIndex],
                        columns[columnIndex]
                    ) <= grid[rowIndex][columnIndex]
                ) 0 else min(rows[rowIndex], columns[columnIndex]) - grid[rowIndex][columnIndex]
            }
        }
        return sum
    }

}