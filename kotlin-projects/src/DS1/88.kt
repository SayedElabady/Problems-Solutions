package DS1

class Solution88 {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        val firstCopy = nums1.take(m)
        var first = 0
        var second = 0
        var index = 0
        while (first < m || second < n) {
            if (second == n || (firstCopy[first] < nums2[second] && first < m)) {
                nums1[index++] = firstCopy[first]
                first++
            } else {
                nums1[index++] = nums2[second]
                second++
            }
        }
    }
}

fun main() {
    val s = Solution88()
    s.merge(intArrayOf(1,2,3,0,0,0), 3, intArrayOf(2,5,6),3)

}