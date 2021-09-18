package Algo1

class Solution283 {
    fun moveZeroes(nums: IntArray): Unit {
        var index = 0
        nums.forEach {
            if(it != 0) {
                nums[index++] = it
            }
        }
        (index..nums.size).forEach { nums[it] = 0 }
    }
}