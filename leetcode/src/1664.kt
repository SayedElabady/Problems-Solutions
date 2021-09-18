class Solution1664 {
    fun waysToMakeFair(nums: IntArray): Int {
        val oddSum = IntArray(nums.size + 1)
        val evenSum = IntArray(nums.size + 1)
        nums.forEachIndexed { index, element ->
            if (index % 2 == 0) evenSum[index] = element
            else oddSum[index] = element
            if (index > 0) {
                evenSum[index] += evenSum[index - 1]
                oddSum[index] += oddSum[index - 1]
            }
        }
        val maxEvenValue = evenSum[nums.size - 1]
        val maxOddValue = oddSum[nums.size - 1]
        var ans = 0
        if (maxEvenValue-nums[0] == maxOddValue) ans++
        for(index in 1 until nums.size)
        {
            if(maxEvenValue - evenSum[index] + oddSum[index-1] == (maxOddValue - oddSum[index] + evenSum[index-1] )) ans++
        }

        return ans
    }
}

fun main() {
    val s = Solution1664()
    println(s.waysToMakeFair(intArrayOf(2,1,6,4)))
    println(s.waysToMakeFair(intArrayOf(1,1,1)))

}