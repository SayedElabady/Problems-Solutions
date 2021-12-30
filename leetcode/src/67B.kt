import java.util.*
import kotlin.collections.ArrayList


class Solution67B {


    fun goodDaysToRobBank(security: IntArray, time: Int): List<Int> {
        if (2 * time + 1 > security.size || security.isEmpty()) return emptyList()
        if (time == 0) return IntArray(security.size) { it }.toList()
        var iterations = security.size - 2 * time
        var startIndex = time

        val prevMap = ArrayDeque<Int>()
        val afterMap = ArrayDeque<Int>()
        if(security[0]<security[time]) prevMap.add(0)
        if(security[time + time]<security[time]) afterMap.add(time + time)
        for (index in 1 until time) {
            if (security[index] > security[index - 1]  || security[index] <security[time]) prevMap.add(index)
        }
        for (index in time + time - 1 downTo time + 1) {
            if (security[index] > security[index + 1]|| security[index] < security[time]) afterMap.add(index)
        }
        val answer = mutableListOf<Int>()
        while (iterations != 0) {
            if (prevMap.isEmpty() && afterMap.isEmpty()) answer.add(
                startIndex
            )

            prevMap.apply {
                if (isNotEmpty() && first == startIndex - time) removeFirst()
                if (security[startIndex] > security[startIndex - 1]|| security[startIndex] >security[startIndex+1]) add(startIndex)

            }
            afterMap.apply {
                if (isNotEmpty() && last == startIndex + 1) removeLast()
                if (iterations != 1)
                    if (security[startIndex+time] > security[startIndex+time+1] || security[startIndex+time] <security[startIndex+1]) add(startIndex+time)

            }
            startIndex++
            iterations--
        }
        return answer
    }

}

fun main() {
    val s = Solution67B()
    //s.goodDaysToRobBank(intArrayOf(1,1,1,1,1), 0)
   // s.goodDaysToRobBank(intArrayOf(1,2,3,4), 1)
    s.goodDaysToRobBank(intArrayOf(1,2,5,4,1,0,2,4,5,3,1,2,4,3,2,4,8), 2)


}