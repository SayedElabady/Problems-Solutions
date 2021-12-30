import kotlin.math.max
import kotlin.math.sqrt

class Solution952 {
    fun largestComponentSize(nums: IntArray): Int {
        val adjcentList = Array<MutableList<Int>>(100001){mutableListOf<Int>()}
        val factorsList = Array<MutableList<Int>>(100001){mutableListOf<Int>()}

        nums.forEach{
            var prevFactor = -1
            for(iterator in 2..sqrt(it.toDouble()).toInt()){
                if(it % iterator == 0){
                    if(it / iterator == iterator){
                        buildItemOfList(adjcentList, factorsList[iterator], if(prevFactor!=-1)prevFactor else iterator, iterator,  it)
                        prevFactor = iterator
                    }else{
                        buildItemOfList(adjcentList, factorsList[iterator],  if(prevFactor!=-1)prevFactor else iterator, iterator,  it)
                        prevFactor = iterator
                        buildItemOfList(adjcentList, factorsList[it / iterator], prevFactor, it / iterator, it)
                        prevFactor = it/iterator
                    }
                }
            }
            if(prevFactor == -1){
                buildItemOfList(adjcentList, factorsList[it], it, it, it)
            }
        }
        var answer = 0
        val visited = BooleanArray(100001)
        for(item in 0 until 10001){
            if(!visited[item] && adjcentList[item].isNotEmpty()){
                answer = max(answer, markWithDFS(item, adjcentList, factorsList, visited))
            }
        }
        return answer
    }

    fun buildItemOfList(adjecntList: Array<MutableList<Int>>, factors: MutableList<Int>, prevFactor:Int,factor:Int, item: Int){

        if(prevFactor!=factor)
            adjecntList[prevFactor].add(factor)
        if(prevFactor==factor)
            factors.add(item)
    }

    fun markWithDFS(item: Int, adjcentList: Array<MutableList<Int>>, factors:Array<MutableList<Int>>, visited : BooleanArray): Int{
        visited[item] = true
        var sum = factors[item].size
        adjcentList[item].forEach{
            if(!visited[it]){
                sum+= markWithDFS(it, adjcentList, factors, visited)
            }
        }
        return sum
    }
}

fun main() {
    val s = Solution952()
        s.largestComponentSize(intArrayOf(2,3,6,7,4,12,21,39))
}