package codility

class CountDistinctSlices {

    fun solution(M: Int, A: IntArray): Int {
        val occ = IntArray(M + 1)
        var ans = 0
        var block = -1
        for (i in A.size - 1 downTo 0) {
            if (occ[A[i]] != 0) {
                block = i
            }
            if (block == -1) {
                ans += A.size - i
            } else {
                ans += block - i + 1
            }
            occ[A[i]] = i
            if (ans > 1000000000) return 1000000000
        }
        return ans
    }

}

fun main() {
    val s = CountDistinctSlices()
    s.solution(6, intArrayOf(3, 4, 5, 5, 2))
}