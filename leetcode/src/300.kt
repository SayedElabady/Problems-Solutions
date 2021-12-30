class Solution300 {
    fun lengthOfLIS(nums: IntArray): Int {
        val piles= mutableListOf<Int>()
        nums.forEach{
            val pile = binarySearch(piles, it)
            if(pile == piles.size){
                piles.add(it)
            }
        }
        return piles.size
    }

    fun binarySearch(piles: MutableList<Int>, target: Int):Int{
        var left = 0
        var right = piles.size - 1
        while(left < right){
            val mid = (left + right + 1) /2
            if(piles[mid] <= target)
                left = mid +1
            else right = mid
        }
        return left

    }
}

fun main() {
    val s = Solution300()
    s.lengthOfLIS(intArrayOf(10,9,2,5,3,7,101,18))
}