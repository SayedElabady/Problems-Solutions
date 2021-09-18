fun search(nums: IntArray, target: Int): Int {
    var start = 0
    var end = nums.size

    while (end >= start) {
        val mid = (end + start + 1) / 2
        if (nums[mid] == target) return mid
        if (nums[mid] < target) start = mid + 1
        if (nums[mid] > target) end = mid - 1
    }
    return -1
}

fun main() {
    print(search(intArrayOf(-1, 0, 3, 5, 9, 12), 2))
}