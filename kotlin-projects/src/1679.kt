class Solution1679 {
    fun maxOperations(nums: IntArray, k: Int): Int {
        nums.sort()
        var l = 0
        var r = nums.size - 1
        var answer = 0
        while (l <= r) {
            when {
                nums[l] + nums[r] == k -> {
                    answer++
                    l++
                    r--
                }
                nums[l] + nums[r] > k -> r--
                nums[l] + nums[r] < k -> l++
            }
        }
        return answer
    }
}

fun main() {
    val s = Solution1679()
    println(s.maxOperations(intArrayOf(1, 2, 3, 4,5), 5))
}