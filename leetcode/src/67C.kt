import java.lang.Math.pow
import java.util.*

class Solution67C {
    fun maximumDetonation(bombs: Array<IntArray>): Int {
        val bombsa = Array(bombs.size) { mutableListOf<Int>() }
        bombs.forEachIndexed { bombIndex, it ->
            for (index in 0 until bombs.size) {
                if (bombIndex == index) continue
                if (isContained(it[0], it[1], it[2], bombs[index][0], bombs[index][1]))
                    bombsa[bombIndex].add(index)
            }
        }
        var answer = 1
        for (index in 0 until bombs.size) {
            val visited = BooleanArray(bombs.size)
            val queue = LinkedList<Int>()
            queue.offer(index)
            var current = 0
            while (queue.isNotEmpty()) {
                val top = queue.pop()
                if (visited[top]) continue
                current++
                visited[top] = true
                bombsa[top].forEach {
                    if (!visited[it])
                        queue.offer(it)
                }
            }
            answer = maxOf(answer, current)
        }
        return answer
    }

    fun isContained(x: Int, y: Int, r: Int, x1: Int, y1: Int): Boolean {
        return (pow((x1 - x).toDouble(), 2.toDouble()) + pow((y1 - y).toDouble(), 2.toDouble())) <= pow(
            r.toDouble(),
            2.toDouble()
        )
    }
}

fun main() {
    val s = Solution67C()
    s.maximumDetonation(arrayOf(intArrayOf(2, 1, 3), intArrayOf(6, 1, 4)))
}