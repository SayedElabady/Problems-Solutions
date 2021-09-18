class Solution34 {
    fun searchRange(nums: IntArray, value: Int): IntArray {
        var l = 0
        var r = nums.size - 1
        if(nums.size < 1 ) return intArrayOf(-1, -1)
        while (r >= l) {
            val mid = (l + r + 1).ushr(1)
            when {
                nums[mid] == value -> {
                    if (nums[l] == value && nums[r] == value) return intArrayOf(l, r)
                    else if (nums[l] != value) l++
                    else if (nums[r] != value) r--
                }
                nums[mid] > value -> r = mid - 1
                else -> l = mid + 1
            }
        }

        if (l >= nums.size || nums[l] != value) return intArrayOf(-1, -1)
        return intArrayOf(l, r)
    }
}