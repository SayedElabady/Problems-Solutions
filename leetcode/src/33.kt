class Solution33 {

    fun search(nums: IntArray, target: Int): Int {
        var l = 0
        var r = nums.size - 1
        while (r > l) {
            val mid = l+ (r - l).ushr(1)
            if (nums[mid] > nums[r]) l = mid + 1
            else r = mid
        }
        nums.sort()
        val minIdx = findMinIdx(nums)
        l = if (target <= nums[nums.size - 1]) minIdx else 0
        r = if (target > nums[nums.size - 1]) minIdx else nums.size - 1
        while (r >= l) {
            val mid = l+  (r-l ).ushr(1)
            if (nums[mid] == target) return mid
            else if (nums[mid] > target) {
                r = mid - 1
            } else if (nums[mid] < target) {
                l = mid + 1
            }
        }
        return -1
    }
    fun findMinIdx(nums: IntArray): Int {
        var start = 0
        var end = nums.size - 1
        while (start < end) {
            val mid = start + (end - start) / 2
            if (nums[mid] > nums[end])
                start = mid + 1
            else
                end = mid
        }
        return start
    }
}

fun main() {
    val s = Solution33()

    s.search(intArrayOf(4,5,6,7,0,1,2), 0)
}