package Algo1

import CoderByte.visitedNodes
import kotlin.math.min

class Solution120 {
    var answer = Int.MAX_VALUE
    fun minimumTotal(triangle: List<List<Int>>): Int {
        val visited = Array(triangle.size) { HashMap<Int, Int>() }
        return traverse(visited, 0, 0, triangle, 0)

    }

    fun traverse(visited: Array<HashMap<Int, Int>>, index: Int, door: Int, triangle: List<List<Int>>, sum: Int): Int {
        if (door >= triangle.size) {
            return sum
        }
        if (visited[door].containsKey(index)) return visited[door][index]!!

        visited[door][index] = traverse(visited, index, door + 1, triangle, sum + triangle[door][index])
        if (index <= door)
            visited[door][index] = min(
                visited[door][index]!!,
                traverse(visited, index + 1, door + 1, triangle, sum + triangle[door][index + 1])
            )
        return visited[door][index]!!
    }
}