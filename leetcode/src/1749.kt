import kotlin.math.abs
import kotlin.math.max

class Solution1749 {
    fun maxAbsoluteSum(nums: IntArray): Int {
        var maxSum = 0
        var minSum = 0

        nums.forEach {
            maxSum += it
            if (maxSum < 0) maxSum = 0
            minSum += it
            if (minSum > 0) minSum = 0
        }
        return maxSum - minSum
    }
}

fun main() {
    val s = Solution1749()
    print(s.maxAbsoluteSum(intArrayOf(2, -5, 1, -4, 3, -2)))
}