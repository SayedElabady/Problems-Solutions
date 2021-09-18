package codility


class MaxDoubleSliceSum {

    fun solution(A: IntArray): Int {
        val starting = IntArray(A.size)
        val endings = IntArray(A.size)
        for (i in 1 until A.size - 1) starting[i] = Math.max(0, starting[i - 1] + A[i])
        for (i in A.size - 2 downTo 1) endings[i] = Math.max(0, endings[i + 1] + A[i])

        var ans = Int.MIN_VALUE

        for (i in 1 until A.size - 1) ans = Math.max(ans, starting[i - 1] + endings[i + 1])
        return ans

    }

}