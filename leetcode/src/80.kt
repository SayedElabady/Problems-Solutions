import kotlin.math.min

class Solution80 {

    fun removeDuplicates(nums: IntArray): Int {
        var currentCount = 1
        var ans = 0
        var i = 0
        while (i < nums.size) {
            if (nums[i] != nums[i - 1]) {
                ans += min(2, currentCount)
                currentCount = 1
                i++
            } else currentCount++
        }
        ans += min(2, currentCount)
        return ans
    }
}