package codility

import java.util.*

class Fish {

    fun solution(A: IntArray, B: IntArray): Int {
        val stack = Stack<Pair<Int, Int>>()
        for (i in 0 until A.size) {
            if (B[i] == 0) {
                while (stack.size > 0 && stack.peek().first < A[i] && stack.peek().second == 1) {
                    stack.pop()
                }
                if (stack.size == 0 || stack.peek().second == 0)
                    stack.push(Pair(A[i], B[i]))
            } else stack.push(Pair(A[i], B[i]))
        }
        return stack.size
    }

}

fun main() {
    val f = Fish()
    f.solution(intArrayOf(1, 2), intArrayOf(0, 0))
    f.solution(intArrayOf(4, 3, 2, 1, 5), intArrayOf(0, 1, 0, 0, 0))

}