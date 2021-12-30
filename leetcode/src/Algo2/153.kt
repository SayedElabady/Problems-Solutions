package Algo2

class Solution153 {
    fun findMin(nums: IntArray): Int {
        var l = 0
        var r = nums.size - 1
        while (l < r) {
            val mid = (l + r + 1) / 2
            if (nums[mid] > nums[r]) {
                l = mid
            } else r = mid +1
        }
        return l
    }
}

fun main() {
    val s = Solution153()
    s.findMin(intArrayOf(3, 4, 5, 1, 2))
}