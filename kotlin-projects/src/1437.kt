class Solution1437 {
    fun kLengthApart(nums: IntArray, k: Int): Boolean {
        var lastPosition = -1
        nums.forEachIndexed { index, number ->
            if (number == 1) {
                lastPosition = if (lastPosition == -1) {
                    index
                } else {
                    if (index - lastPosition - 1  < k) return false
                    index
                }
            }
        }
        return true
    }
}

fun main() {
    val s = Solution1437()
    s.kLengthApart(intArrayOf(1, 0, 0, 1, 0,0, 1), 2)
}