class Solution4 {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        val firstArraySize = nums1.size
        val secondArraySize = nums2.size
        val newNumbers = when {
            nums1.isEmpty() -> nums2
            nums2.isEmpty() -> nums1
            else -> IntArray(firstArraySize + secondArraySize)
        }
        var firstArrayPointer = 0
        var secondArrayPointer = 0
        for (index in 0 until (firstArraySize + secondArraySize) ) {
            if (firstArrayPointer < firstArraySize && secondArrayPointer < secondArraySize) {
                if (nums1[firstArrayPointer] < nums2[secondArrayPointer]) {
                    newNumbers[index] = nums1[firstArrayPointer++]
                } else {
                    newNumbers[index] = nums2[secondArrayPointer++]
                }
            } else if (firstArrayPointer >= firstArraySize) {
                newNumbers[index] = nums2[secondArrayPointer++]
            } else {
                newNumbers[index] = nums1[firstArrayPointer++]
            }
        }
        if (newNumbers.size % 2 == 0) {
            return (newNumbers[newNumbers.size / 2] + newNumbers[newNumbers.size / 2 - 1]).toDouble() / 2
        }

        return newNumbers[newNumbers.size / 2].toDouble()

    }
}

fun main() {
    val s = Solution4()
    s.findMedianSortedArrays(intArrayOf(1), intArrayOf(1))
}