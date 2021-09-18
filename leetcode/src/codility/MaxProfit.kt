package codility

import kotlin.math.max

class MaxProfit {

    fun solution(A: IntArray): Int {
        var currMin = Int.MAX_VALUE
        var currMax = Int.MIN_VALUE
        var ans = 0
        for (i in 0 until A.size) {
            when {
                A[i] < currMin -> currMin = A[i]
                A[i] > currMax -> {
                    currMax = A[i]
                    ans = max(currMax - currMin, ans)
                }
                else -> ans = max(A[i] - currMin, ans)
            }
        }
        return ans
    }


}

fun main() {
    val s = MaxProfit()
    s.solution(intArrayOf(8,9,3,6,1,2))
}