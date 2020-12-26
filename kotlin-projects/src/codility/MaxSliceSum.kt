package codility

    import kotlin.math.max

class MaxSliceSum {
    fun solution(A: IntArray): Int {
        var maxSlice = -1000000
        var ans = -1000000
        for (i in 0 until A.size) {
            maxSlice = max(A[i], maxSlice + A[i])
            ans = max(maxSlice, ans)
        }
        return ans
    }


}