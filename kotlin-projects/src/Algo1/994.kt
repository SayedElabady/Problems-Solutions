package Algo1

import java.util.*
import kotlin.math.max
import kotlin.math.min

class Solution994 {
    fun orangesRotting(grid: Array<IntArray>): Int {
        val queue = ArrayDeque<Triple<Int, Int, Int>>()
        val visited = Array(15) { BooleanArray(15) }
        val coordinates = arrayOf(Pair(-1, 0), Pair(1, 0), Pair(0, 1), Pair(0, -1))
        var answer = 0

        for (x in 0..grid.size-1) {
            for (y in 0..grid[0].size-1) {
                if (grid[x][y] == 2 && !visited[x][y]) {
                    queue.add(Triple(x, y, 0))

                }
            }
        }
        while (queue.isNotEmpty()) {
            val point = queue.pop()
            visited[point.first][point.second] = true
            answer = max(answer, point.third)
            coordinates.forEach {
                if (areCoordinatesValid(point.first + it.first, point.second + it.second, grid)
                    && grid[point.first + it.first][point.second + it.second] == 1
                    && !visited[point.first + it.first][point.second + it.second]
                )
                    queue.push(Triple(point.first + it.first, point.second + it.second, point.third + 1))
            }
            for (x in 0 until grid.size) {
                for (y in 0 until grid[0].size) {
                    if(grid[x][y] == 1 && !visited[x][y]) return -1
                }
            }
        }
        return answer
    }

    fun areCoordinatesValid(x: Int, y: Int, grid: Array<IntArray>): Boolean {
        return x >= 0 && x <= grid.size - 1 && y >= 0 && y <= grid[0].size - 1
    }
}

fun main() {
    val s = Solution994()
    s.orangesRotting(arrayOf(intArrayOf(2, 1, 1), intArrayOf(1, 1, 0), intArrayOf(0, 1, 1)))
}