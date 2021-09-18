package Algo1

class Solution189 {
    fun rotate(nums: IntArray, k: Int) {
        val rotator = k % nums.size
        val original = nums.copyOf()
        original.forEachIndexed{index, item ->
            nums[(index + rotator)% nums.size] = item
        }
//        if (rotator == 0) return
//        var indexToRotate = rotator
//        var middle = nums[0]
//        while (true) {
//            val temp = nums[indexToRotate]
//            nums[indexToRotate] = middle
//            middle = temp
//            if(indexToRotate == 0) return
//            indexToRotate = (rotator + indexToRotate) % nums.size
//        }
    }
}

fun main() {
    val s = Solution189()
    s.rotate(intArrayOf(-1,-100,3,99), 2)
}