package DS1

import java.util.*
import kotlin.math.max

class Solution1 {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        if(nums.size == 2) return  intArrayOf(0,1)
        val sorted = nums.sorted().toIntArray()
        val maxIndex = sorted.findLast { it < target } ?: sorted.size - 1
        for (iterator in 0..sorted.size) {
            val searched = Arrays.binarySearch(sorted, target - sorted[iterator])
            if (searched > 0) return getIndices(nums, sorted[iterator], target - sorted[iterator])
        }
        return intArrayOf()
    }

    fun getIndices(nums: IntArray, a: Int, b: Int): IntArray {
        var answer = 0
        nums.forEachIndexed { index, it ->
                if (it == a) answer = index
                return@forEachIndexed
        }
        nums.forEachIndexed { index, it -> if (it == b) return intArrayOf(index, answer)}
        return intArrayOf()
    }
}