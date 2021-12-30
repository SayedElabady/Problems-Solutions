import kotlin.math.max

class Solution368 {
    fun largestDivisibleSubset(nums: IntArray): List<Int> {
        nums.sort()
        val count = IntArray(nums.size) { 1 }
        var maxIndex = 0
        var maxValue = -1
        val previousIndex = IntArray(nums.size) { -1 }

        for (first in 1 until nums.size){
            for(second in 0 until first){
                if(count[second] + 1 > count[first] && nums[second] % nums[second] == 0){
                    count[first] = count[second] + 1
                    previousIndex[first] = second
                    if(count[first] > maxValue){
                        maxValue = count[first]
                        maxIndex = first
                    }
                }
            }
        }
        val answer = mutableListOf<Int>()
        while (maxIndex != -1){
            answer.add(nums[maxIndex])
            maxIndex = previousIndex[maxIndex]
        }
        return  answer.toList()
    }


}