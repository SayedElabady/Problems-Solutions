package Algo1

import java.util.*

class Solution167 {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        if(nums.size == 2) return  intArrayOf(0,1)
        for (iterator in 0..nums.size) {
            val searched = Arrays.binarySearch(nums, target - nums[iterator])
            if (searched > 0) return getIndices(nums, nums[iterator], target - nums[iterator])
        }
        return intArrayOf()
    }

    fun getIndices(nums: IntArray, a: Int, b: Int): IntArray {
        var answer = 0
        nums.forEachIndexed { index, it ->
            if (it == a) answer = index
            return@forEachIndexed
        }
        nums.forEachIndexed { index, it -> if (it == b) return intArrayOf(answer+1, index+1)}
        return intArrayOf()
    }
}