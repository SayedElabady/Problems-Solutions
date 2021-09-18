import java.util.*

class Solution946 {
    fun validateStackSequences(pushed: IntArray, popped: IntArray): Boolean {
        val stack = Stack<Int>()
        var popIndex = 0
        pushed.forEach {
            stack.push(it)
            while (popIndex <= popped.size - 1 && stack.isNotEmpty() && popped[popIndex] == stack.peek()) {
                stack.pop()
                popIndex++
            }
        }
        return popIndex == popped.size  && stack.empty()
    }
}

fun main() {
    val s = Solution946()
    s.validateStackSequences(intArrayOf(1,2,3,4,5), intArrayOf(4,5,3,2,1))
}