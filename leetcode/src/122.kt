import kotlin.math.min
import kotlin.math.max


class Solution122{


    fun maxProfit(prices: IntArray): Int {
        val peekIndices = mutableListOf<Int>()
        if(prices.size==1) return 0
        if(prices.size==2) return max(0, prices[1]-prices[0])

        for(index in 2 until prices.size){
            if(prices[index] < prices[index-1])
                peekIndices.add(index-1)
        }
        if(prices.last() > prices[prices.lastIndex - 1]) peekIndices.add(prices.lastIndex)
        if(peekIndices.isEmpty())return 0
        var nextPeekIndex = 0
        var currentPeekMax = 0
        var answer = 0
        for(index in prices.indices){
            if(index==peekIndices[nextPeekIndex]){
                nextPeekIndex++
                answer += currentPeekMax
                currentPeekMax = 0
                if(nextPeekIndex == peekIndices.size) return answer
                continue
            }
            currentPeekMax = max(currentPeekMax, prices[peekIndices[nextPeekIndex]] - prices[index])
        }
        return answer
    }

}

fun main() {
    val s = Solution122()
    s.maxProfit(intArrayOf(1,9,6,9,1,7,1,1,5,9,9,9))
}