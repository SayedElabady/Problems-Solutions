class Solution74 {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        val M = matrix[0].size
        var targetRow = -1
        for (i in matrix.indices) {
            if (matrix[i][0] <= target && matrix[i][M] >= target) {
                targetRow = i
                break
            }
        }
        if (targetRow == -1) return false
        if (binarySearch(a = matrix[targetRow], key = target) == -1) return false
        return true

    }

    private fun binarySearch(a: IntArray, fromIndex: Int = 0, toIndex: Int = a.size, key: Int): Int {
        var low = fromIndex
        var high = toIndex - 1

        while (low <= high) {
            val mid = (low + high).ushr(1)
            val midVal = a[mid]
            if (midVal < key) {
                low = mid + 1
            } else {
                if (midVal <= key) {
                    return mid
                }

                high = mid - 1
            }
        }

        return -1
    }

}