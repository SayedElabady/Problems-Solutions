import kotlin.math.max
import kotlin.math.min
import kotlin.math.abs

class Solution174 {
    fun calculateMinimumHP(dungeon: Array<IntArray>): Int {
        val m = dungeon.size
        val n = dungeon[0].size
        val graph = Array(m) { IntArray(n) }


        for(x in m-1 downTo 0){
            for(y in n-1 downTo 0){
                var maxValue = Int.MIN_VALUE
                if(x+1 < m){
                    maxValue = max(maxValue, dungeon[x][y] + graph[x+1][y])
                }
                if(y+1 < n){
                    maxValue = max(maxValue, dungeon[x][y] + graph[x][y+1])
                }
                if(maxValue == Int.MIN_VALUE){
                    graph[x][y] = dungeon[x][y]
                } else {
                    graph[x][y] = min(maxValue, 0)
                }
            }
        }
        return if(graph[0][0]>=0) 1 else abs(graph[0][0]) + 1
    }

}

fun main() {
    val s = Solution174()
    //s.calculateMinimumHP(arrayOf(intArrayOf(-2, -3, 3), intArrayOf(-5, -10, 1), intArrayOf(10, 30, -5)))
 //   s.calculateMinimumHP(arrayOf(intArrayOf(3,0,-3), intArrayOf(-3,-2,-2), intArrayOf(3,1,-3)))
    s.calculateMinimumHP(arrayOf(intArrayOf(-3,5)))


}