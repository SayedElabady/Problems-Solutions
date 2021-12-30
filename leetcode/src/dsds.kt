import kotlin.math.max

class Solutiondsdsd {
    fun platesBetweenCandles(s: String, queries: Array<IntArray>): IntArray {
        val nearestLeftCandles = IntArray(s.length){ -1 }
        val nearestRightCandles = IntArray(s.length){ -1 }
        val platesCounts = IntArray(s.length+1)

        val firstCandleIndex = s.indexOfFirst{ it == '|' }
        var candleIndex = firstCandleIndex
        (0 until s.length).forEach{
            if(s[it] == '|') candleIndex = it
            nearestRightCandles[it] = candleIndex
        }
        val lastCandle = s.indexOfLast{it == '|' }
        candleIndex = lastCandle
        (s.length-1 downTo 0).forEach{
            if(s[it] == '|') candleIndex = it
            nearestLeftCandles[it] = candleIndex
        }

        var currentCount = 0
        (firstCandleIndex..lastCandle).forEach{
            if(s[it] =='*')currentCount++
            platesCounts[it]=currentCount
        }
        val answers = IntArray(queries.size)
        queries.forEachIndexed{index, it ->
            answers[index] = platesCounts[nearestRightCandles[it[1]]] - platesCounts[nearestLeftCandles[it[0]]]
            answers[index] = max(0, answers[index])
        }
        return answers
    }
}

fun main() {
    val s = Solutiondsdsd()
    s.platesBetweenCandles("***|**|*****|**||**|*", arrayOf(intArrayOf(1,17), intArrayOf(4,5), intArrayOf(14,17), intArrayOf(5,11), intArrayOf(15,16)  ))
}