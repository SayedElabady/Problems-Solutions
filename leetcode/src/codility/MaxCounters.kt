package codility

import kotlin.math.max

class MaxCounters {
    fun solution(N: Int, A: IntArray): IntArray {
        var max = 0
        var currentLimit = -1
        val res = IntArray(N)
        for (i in 0 until A.size) {
            if (A[i] == N + 1) {
                currentLimit = max
            } else {
                if (currentLimit != -1) {
                    if (res[A[i] - 1] <= currentLimit) {
                        res[A[i] - 1] = currentLimit + 1
                    }else
                        res[A[i] - 1]++
                } else {
                    res[A[i] - 1]++
                }
                max = max(max, res[A[i] - 1])
            }

        }
        if (currentLimit == -1) return res
        for (i in 0 until N) {
            if (res[i] < currentLimit) res[i] = currentLimit
        }
        return res
    }
}

fun main() {
    val s = MaxCounters()
    s.solution(5, intArrayOf(3, 4, 4, 6, 1,5,5,5,5,6))
}