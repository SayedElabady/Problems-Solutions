class Solution410 {
    fun splitArray(nums: IntArray, m: Int): Int {
        var left = nums.max()?:1
        var right = 1000_000_000
        while(right > left){
            val mid = left + (right - left)/2
            if(calucateParts(nums, mid) <=m){
                right = mid
            }else left = mid + 1
        }
        return right
    }

    fun calucateParts(nums: IntArray, target: Int): Int{
        var index =0
        var answer = 0
        var currentSum = 0
        while(index < nums.size){
            currentSum = 0
            while(index < nums.size && currentSum + nums[index] <= target){
                currentSum += nums[index]
                index++
            }
            answer++
        }
        return answer
    }
}