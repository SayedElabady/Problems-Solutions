package Algo1

import java.util.*

class Solution704 {
    fun search(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size - 1
        while (left <= right) {
            val mid = (left + right + 1) / 2
            when {
                target == nums[mid] -> return mid
                nums[mid] > target -> right = mid - 1
                else -> left = mid
            }
        }
        return -1
    }
}