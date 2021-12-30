import kotlin.math.max
import kotlin.math.min


class Solution57 {
    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
        val indicesToMerge = mutableListOf<Int>()
        var leastStart = newInterval[0]
        var maxEnding = newInterval[1]
        var indexToInsert = -1
        for(iteratingIndex in intervals.indices){
            if(intervals[iteratingIndex][0] >= newInterval[0]  && indexToInsert == -1){
                indexToInsert = iteratingIndex
            }
            if((intervals[iteratingIndex][0] <= maxEnding && intervals[iteratingIndex][0] >=leastStart)
                || (intervals[iteratingIndex][1] <= maxEnding && intervals[iteratingIndex][1] >= leastStart)
                || (intervals[iteratingIndex][0] < leastStart && intervals[iteratingIndex][1] > maxEnding)){
                indicesToMerge.add(iteratingIndex)
                leastStart = min(leastStart, intervals[iteratingIndex][0])
                maxEnding = max(maxEnding, intervals[iteratingIndex][1])
            }
        }
        val answer = mutableListOf<IntArray>()
        if(indicesToMerge.isEmpty()){
            for(index in intervals.indices){
                if(index == indexToInsert){
                    answer.add(newInterval)
                }
                answer.add(intervals[index])
            }
        }else{
            val mergedInterval = intArrayOf(leastStart, maxEnding)
            var indicesIterator = 0
            for(index in intervals.indices){
                if(index == indicesToMerge[0]){
                    answer.add(mergedInterval)
                }
                if(indicesIterator < indicesToMerge.size && index == indicesToMerge[indicesIterator]){
                    indicesIterator++
                }else{
                    answer.add(intervals[index])
                }
            }
        }
        return answer.toTypedArray()
    }
}

fun main() {
    val s = Solution57()
    s.insert(arrayOf(intArrayOf(0,5), intArrayOf(8,9)), intArrayOf(2,3))
    s.insert(arrayOf(intArrayOf(1,5)), intArrayOf(2,3))

}