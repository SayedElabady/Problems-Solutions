class Solution48 {
    fun rotate(matrix: Array<IntArray>): Unit {
        val N = matrix[0].size
        var valueToRemember = 0
        var temp = 0
        for (outerIndex in 0 until kotlin.math.max(1, N - 2)) {
            for (index in outerIndex until N - 1 - outerIndex ) {
                valueToRemember = matrix[N - index - 1][outerIndex]
                temp = matrix[outerIndex][index]
                matrix[outerIndex][index] = valueToRemember
                valueToRemember = temp

                temp = matrix[index][N - 1 - outerIndex]
                matrix[index][N - 1 - outerIndex] = valueToRemember
                valueToRemember = temp

                temp = matrix[N - 1 - outerIndex][N - index - 1]
                matrix[N - 1 - outerIndex][N - index - 1] = valueToRemember
                valueToRemember = temp

                matrix[N - index - 1][outerIndex] = valueToRemember
            }
        }
//        matrix.forEach { row ->
//            row.forEach {
//                print("$it ")
//            }
//            println()
//        }
    }
}

fun main() {
    val s = Solution48()
    s.rotate(
        arrayOf(
            intArrayOf(5, 1, 9, 11),
            intArrayOf(2, 4, 8, 10),
            intArrayOf(13, 3, 6, 7),
            intArrayOf(15, 14, 12, 16)
        )
    )
}