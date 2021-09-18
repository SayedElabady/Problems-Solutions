import kotlin.math.max
import kotlin.math.min

class Solution1292 {

    fun maxSideLength(mat: Array<IntArray>, threshold: Int): Int {
        val sum = mat
        var ans = Int.MIN_VALUE
        for (i in 0 until mat.size)
            for (j in 1 until mat[i].size)
                sum[i][j] += sum[i][j - 1]

        for (i in 0 until mat.size) {
            for (j in 0 until mat[i].size) {
                for (k in 1 until min(mat.size - i, mat[i].size - j)) {
                    var currentSum = 0
                    for (m in i until i + k +1)
                        currentSum += sum[m][j + k] - if (j == 0) 0 else sum[m][j - 1]
                    if (currentSum <= threshold)
                        ans = max(ans, k + 1)
                }

            }
        }

        return max(0, ans)
    }
}

fun main() {
    val s = Solution1292()
    val f = intArrayOf(1, 1, 3, 2, 4, 3, 2)
    val se = intArrayOf(1, 1, 3, 2, 4, 3, 2)
    val th = intArrayOf(1, 1, 3, 2, 4, 3, 2)

    s.maxSideLength(arrayOf(f, se, th), 4)
}