package DS1

class Solution350 {
    fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
        val occ = IntArray(1001)
        nums1.forEach { occ[it]++ }
        val result = mutableListOf<Int>()
        nums2.forEach {
            if (occ[it] > 0) {
                occ[it]--
                result.add(it)
            }
        }
        return result.toIntArray()
    }
}