package Algo1

import kotlin.math.max

class Solution198 {
    fun rob(nums: IntArray): Int {
        return traverse(Array(101) { IntArray(9001) { -1 } }, 0, nums, 0)
    }

    fun traverse(visited: Array<IntArray>, index: Int, nums: IntArray, total: Int): Int {
        if (index >= nums.size) return total
        if (visited[index][total] != -1) return visited[index][total]

        visited[index][total] =
            max(traverse(visited, index + 1, nums, total), traverse(visited, index + 2, nums, total + nums[index]))
        return visited[index][total]
    }
}