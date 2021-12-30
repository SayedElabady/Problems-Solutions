import HackerRank.vowelsubstring
import kotlin.math.cos
import kotlin.math.cosh
import kotlin.math.min
import kotlin.math.pow

class Solution5924 {
    val positions = arrayOf(intArrayOf(1, 0), intArrayOf(-1, 0),intArrayOf(0, -1), intArrayOf(0, 1))
    fun minCost(startPos: IntArray, homePos: IntArray, rowCosts: IntArray, colCosts: IntArray): Int {
        val m = rowCosts.size
        val n = colCosts.size
        val visited = HashMap<IntArray, Int>()
        val power = 2.0.pow(2).toInt()

        return traverse(startPos, homePos, rowCosts, colCosts, visited,0)
    }

    fun traverse(
        position: IntArray,
        homePos: IntArray,
        rowCosts: IntArray,
        colCosts: IntArray,
        visited: HashMap<IntArray, Int>,
        costSoFar: Int
    ): Int {
        if (position[0] == homePos[0] && position[1] == homePos[1]) return 0
        if(visited.contains(position) && visited[position]!! < costSoFar) return visited[position]!!
        visited[position] = Int.MAX_VALUE - 10000
        for (index in 0 until 4) {
            val newX = position[0] + positions[index][0]
            val newY = position[1] + positions[index][1]
            if (isValid(intArrayOf(newX, newY), rowCosts.size, colCosts.size)) {
                if (index == 2 || index == 3) {
                    visited[position] =  min(
                        visited[position]!!,
                        traverse(intArrayOf(newX, newY), homePos, rowCosts, colCosts, visited, costSoFar + colCosts[newY])
                    )
                }else{
                    visited[position] = rowCosts[newX] + min(
                        visited[position]!!,
                        traverse(intArrayOf(newX, newY), homePos, rowCosts, colCosts, visited, costSoFar + rowCosts[newX])
                    )
                }
            }
        }
        return visited[position]!!

    }

    fun isValid(position: IntArray, m: Int, n: Int): Boolean {
        return position[0] in 0 until m && position[1] in 0 until n
    }
}

fun main() {
    val s = Solution5924()
    s.minCost(intArrayOf(1,2), intArrayOf(3,3), intArrayOf(10,1,2,3), intArrayOf(10,7,8,9))
}