import kotlin.math.abs

class Solution977 {
    fun sortedSquares(A: IntArray): IntArray {
        var l = 0
        var r = A.size - 1
        val ans = IntArray(A.size){0}
        for (i in A.size - 1 downTo 0) {
            if (abs(A[l]) > abs(A[r])) {
                ans[i] = A[l] * A[l]
                l++
            } else {
                ans[i] = A[r] * A[r]
                r--
            }
        }
        return ans
    }
}

fun main(){
    val s = Solution977()
    s.sortedSquares(intArrayOf(-4,-1,0,3,10))
}