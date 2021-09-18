import java.util.*

class Solution1631 {
    val directions = intArrayOf(0, -1, 0, 1, 0)
    fun minimumEffortPath(heights: Array<IntArray>): Int {
        val visited = Array(101) { BooleanArray(101) }
        var left = 0
        var right = 1000000
        var answer = Int.MAX_VALUE
        while (left < right) {
            val mid = (left + right).ushr(1)
            visited.forEachIndexed {index, _ -> visited[index] = BooleanArray(101) }
            if (isPossible(0, 0, heights, visited, mid)) {
                right = mid
                answer = Math.min(answer, mid)
            } else {
                left = mid + 1
            }
        }
        return answer
    }

    fun isPossible(x: Int, y: Int, heights: Array<IntArray>, visited: Array<BooleanArray>, value: Int): Boolean {
        if (x == heights.size - 1 && y == heights[0].size - 1) return true
        visited[x][y] = true
        var toReturn = false
        for (index in 0 until 4) {
            val newX = x + directions[index]
            val newY = y + directions[index + 1]
            if (newX >= 0 && newX <= heights.size - 1 && newY >= 0 && newY <= heights[0].size - 1
                && Math.abs(heights[x][y] - heights[newX][newY]) <= value && !visited[newX][newY]
            ) {
                toReturn = toReturn.or(isPossible(newX, newY, heights, visited, value))
            }
        }
        return toReturn
    }


}

fun main() {
    val s = Solution1631()
    s.minimumEffortPath(arrayOf(intArrayOf(1, 2, 2), intArrayOf(3, 8, 2), intArrayOf(5, 3, 5)))
}