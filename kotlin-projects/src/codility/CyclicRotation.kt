package codility

class CyclicRotation {
    fun solution(A: IntArray, K: Int): IntArray {
        val N = A.size
        val ans = IntArray(N)
        val steps = K % N
        for (i in 0 until N) {
            ans[(i + steps) % N] = A[i]
        }
        return ans
    }
}