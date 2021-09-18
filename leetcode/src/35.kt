class Soultion35 {

    fun searchInsert(nums: IntArray, target: Int): Int {

        return binarySearch(nums, target)

    }

    fun binarySearch(nums: IntArray, value: Int): Int {
        var l = 0
        var r = nums.size - 1
        while (r >= l) {
            val mid = (l + r + 1).ushr(1)
            when {
                nums[mid] == value -> return mid
                nums[mid] > value -> r = mid - 1
                else -> l = mid + 1
            }
        }
        return l
    }


}

fun main() {
        val s = Soultion35()
    s.binarySearch(intArrayOf(1,3,5,6) , 2)
}