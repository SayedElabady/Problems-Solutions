import kotlin.math.max

class Solution128 {
    fun longestConsecutive(nums: IntArray): Int {
        val set = hashSetOf<Int>()
        var ans = 0
        for (num in nums) {
            set.add(num)
        }
        for (num in set) {
            var currNum = num
            var currMax = 1
            while (set.contains(currNum + 1)) {
                ++currMax
                ++currNum
            }
            ans = max(ans, currMax)
        }
        return ans
    }
}