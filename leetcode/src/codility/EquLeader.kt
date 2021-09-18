package codility

import java.util.*

class EquLeader {

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
        if (stack.size == 0) return 0
        val dom = stack.pop()
        var cnt = 0
        for (i in 0 until A.size) if (A[i] == dom) cnt++
        if (cnt <= A.size / 2) return 0
        val startings = IntArray(A.size)
        startings[0] = if (A[0] == dom) 1 else 0
        val endings = IntArray(A.size)
        endings[endings.size - 1] = if (A[A.size - 1] == dom) 1 else 0
        for (i in 1 until A.size) startings[i] = startings[i - 1] + if (A[i] == dom) 1 else 0
        for (i in A.size - 2 downTo 0) endings[i] = endings[i + 1] + if (A[i] == dom) 1 else 0
        var ans = 0
        for (i in 0 until A.size-1) {
            if (startings[i] > (i +1) / 2 && endings[i + 1] > (A.size - i-1) / 2)
                ans++
        }
        return ans
    }

}

fun main() {
    val s = EquLeader()
    s.solution(intArrayOf(4, 3, 4, 4, 4, 2))
}