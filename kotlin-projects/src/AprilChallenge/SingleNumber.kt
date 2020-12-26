package AprilChallenge

class SingleNumber {
    fun singleNumber(nums: IntArray): Int {
        nums.sort()
        for (i in 1 until nums.size step 2) {
            if (nums[i] != nums[i - 1]) return nums[i-1]
        }
        return nums[nums.lastIndex]
    }
}

fun main() {
    val s = SingleNumber()
    print(s.singleNumber(intArrayOf(4, 1, 2, 1, 2)))
    print(s.singleNumber(intArrayOf(2, 2, 1)))
    print(s.singleNumber(intArrayOf(2, 2, 1,1,3,3,9,9,0)))


}