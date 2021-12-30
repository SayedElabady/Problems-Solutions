import kotlin.math.max
class Solution152 {
    fun maxProduct(nums: IntArray): Int {
        val sum = IntArray(nums.size)
        val nextZeros = IntArray(nums.size){ -1 }
        val nextNegative = IntArray(nums.size){ -1 }
        var lastNegativeIndex = -1
        var lastZeroIndex = -1
        for(index in nums.size - 1 downTo 0){
            if(nums[index] == 0){
                nextZeros[index] = lastZeroIndex
                nextNegative[index] = lastNegativeIndex
                lastZeroIndex = index
            }else if(nums[index] < 0){
                nextNegative[index] = lastNegativeIndex
                nextZeros[index] = lastZeroIndex
                lastNegativeIndex = index
            }else{
                nextNegative[index] = lastNegativeIndex
                nextZeros[index] = lastZeroIndex
            }

        }

        var product = 1
        var answer = Int.MIN_VALUE
        for(index in nums.indices){
            if(nums[index] > 0){
                sum[index] = product * nums[index]
                product = sum[index]
            }else if(nums[index] == 0){
                sum[index] = 0
                product = 1
            }else {
                if(nextNegative[index] != -1){
                    if(nextZeros[index] != -1 && nextZeros[index] < nextNegative[index]){
                        sum[index] = 1
                        product = 1
                    }else{
                        sum[index] = product * nums[index]
                        product = sum[index]
                    }
                }else{
                    product = product * nums[index]
                    answer = max(answer, product)
                    if(product > 0){
                        sum[index] = product
                    }else{
                        sum[index] = 0
                    }
                }

            }
            answer = max(answer, sum[index])
        }
        return answer
    }
}

fun main() {
    val s = Solution152()
    s.maxProduct(intArrayOf(3,-1,7,10,1,-1))
}