package codility

import java.util.*

class Dominator {
    fun solution(A: IntArray): Int {
        val stack = Stack<Int>()
        for (i in 0 until A.size) {
            stack.push(A[i])
            if (stack.size > 1) {
                if (stack.peek() != stack[stack.size - 2]) {
                    stack.pop()
                    stack.pop()
                }
            }
        }
        if (stack.size == 0) return -1
        val dom = stack.pop()
        var cnt = 0
        for (i in 0 until A.size) if (A[i] == dom) cnt++
        return if (cnt > A.size / 2) cnt
        else -1
    }

}

fun main() {
    val s = Dominator()
    s.solution(intArrayOf(3, 4, 3, 2, 3, -1, 3, 3))
}