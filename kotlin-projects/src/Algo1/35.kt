package Algo1

class Solution35 {
    fun searchInsert(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size - 1
        while (left <= right) {
            val mid = (left + right + 1) / 2
            when {
                target == nums[mid] -> return mid
                nums[mid] > target -> right = mid - 1
                else -> left = mid + 1
            }
        }
        return left
    }
}