package codility

class OddOccurrencesInArray {
    fun solution(A: IntArray): Int {
        A.sort()
        for (i in 0 until A.size - 1 step 2) {
            if (A[i] != A[i + 1]) return A[i]
        }
        return A[A.size - 1]
    }
}