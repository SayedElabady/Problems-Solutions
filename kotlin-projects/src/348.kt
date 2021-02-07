import kotlin.random.Random

class Solution348(val nums: IntArray) {

    var current = nums.clone()

    fun reset(): IntArray {
        return nums
    }

    fun shuffle(): IntArray {
        for (index in current.indices) {
            if (index != current.size - 1)
                swap(current, Random.nextInt(current.size - index) + index, index)
        }
        return current
    }

    private fun swap(array: IntArray, first: Int, second: Int) {
        val temp = array[first]
        array[first] = array[second]
        array[second] = temp
    }

}

fun main() {
    val s = Solution348(intArrayOf(1,2,3))

}