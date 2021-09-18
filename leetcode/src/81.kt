class Solution81 {

    fun search(nums: IntArray, target: Int): Boolean {
        if (nums.isEmpty() || (nums.size == 1 && nums[0] != target)) return false
        val minIdx = findMinIdx(nums)
        var l = if (target <= nums[nums.size - 1]) minIdx else 0
        var r = if (target > nums[nums.size - 1]) minIdx else nums.size - 1
        while (r >= l) {
            val mid = l + (r - l) / 2
            when {
                nums[mid] == target -> return true
                nums[mid] > target -> r = mid - 1
                else -> l = mid + 1
            }
        }

        return true
    }

    fun findMinIdx(nums: IntArray): Int {
        var l = 0
        var r = nums.size - 1
        while (r > l) {
            val mid = l + (r - l) / 2
            if (nums[mid] > nums[r]) l = mid + 1
            else r = mid
        }
        return l
    }
}

fun main() {
    val s = Solution81()
    s.search(intArrayOf(2, 5, 6, 0, 0, 1, 2), 3)
}