package codility

class AbsDistinct {
    fun solution(A: IntArray): Int {
        val toBeSorted = IntArray(A.size)
        for (i in 0 until A.size) toBeSorted[i] = Math.abs(A[i])
        toBeSorted.sort()
        var ans = 0
        var i = 0
        while (i < A.size) {
            while (i + 1 < A.size && toBeSorted[i] == toBeSorted[i + 1]) i++
            i++
            ans++
        }
        return ans
    }
}