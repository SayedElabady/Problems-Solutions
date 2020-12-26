package codility

class MinAvgTwoSlice {
    fun solution(A: IntArray): Int {
        var currentMin = 20001.0
        var ans = 0
        for (i in 0 until A.size - 2) {
            if ((A[i].toDouble() + A[i + 1].toDouble()) / 2.0 < currentMin) {
                currentMin = (A[i].toDouble() + A[i + 1].toDouble() )/ 2.0
                ans = i
            }
            if ((A[i].toDouble() + A[i + 1].toDouble() + A[i + 2].toDouble()) / 3.0 < currentMin) {
                currentMin =( A[i].toDouble() + A[i + 1].toDouble() + A[i + 2].toDouble()) / 3.0
                ans = i
            }
        }
        if ((A[A.size - 2].toDouble() + A[A.size - 1].toDouble()) / 2.0 < currentMin) ans = A.size - 2
        return ans
    }
}

fun main() {
    val s = MinAvgTwoSlice()
    s.solution(intArrayOf(10, 10, -1, 2, 4, -1, 2, -1))
}