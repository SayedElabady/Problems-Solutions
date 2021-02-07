class Solution462 {
    fun minMoves2(nums: IntArray): Int {
        nums.sort()
        var answer = 0
        val mid = nums[nums.size/2]
        for (item in nums) answer += kotlin.math.abs(item - mid)
        return answer
    }
}