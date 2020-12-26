class Solution969 {
    fun pancakeSort(A: IntArray): List<Int> {
        val ans = mutableListOf<Int>()
        for (i in A.size downTo 1) {
            var currentLargestIndex = 0
            while (A[currentLargestIndex] != i) currentLargestIndex++
            if (currentLargestIndex != i - 1) {
                reverse(A, currentLargestIndex + 1)
                ans.add(currentLargestIndex + 1)
                reverse(A, i)
                ans.add(i)
            }
        }
        return ans.toList()
    }

    fun reverse(A: IntArray, k: Int) {
        var i = 0
        var j = k - 1
        while (i < j) {
            val tmp = A[j]
            A[j] = A[i]
            A[i] = tmp
            ++i
            --j
        }
    }


}