class Solution442 {
    fun findDuplicates(nums: IntArray): List<Int> {
//        nums.apply { sort() }
////        var i = 0
////        for (index in 1 until nums.size) {
////            if (nums[index] == nums[index - 1])
////                nums[i++] = nums[index]
////        }
////
////        return nums.copyOfRange(0, i).toList()
        val res = mutableListOf<Int>()
        nums.forEachIndexed { index, element ->
            val it = Math.abs(nums[index]) - 1
            if (nums[it] < 0)
                res.add(it + 1)
            nums[it] = -nums[it]
        }
        return res
    }
}