package DS1

class Solution53 {
    fun maxSubArray(nums: IntArray): Int {
        var maxSoFar = 0
        var max = Int.MIN_VALUE
        nums.forEach {
            maxSoFar += it
            max = kotlin.math.max(max, maxSoFar)
            if(maxSoFar < 0 ) maxSoFar = 0
        }
        return max
    }
}

fun main() {
    val s= Solution53()
    s.maxSubArray(intArrayOf(-2,1,-3,4,-1,2,1,-5,4))
}