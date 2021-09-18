import java.util.Stack

class S921 {
    fun minAddToMakeValid(S: String): Int {
        val stack = Stack<Char>()
        var ans = 0
        for (curr in S) {
            when {
                curr == '(' -> stack.push(curr)
                stack.isNotEmpty() -> stack.pop()
                else -> ans++
            }
        }
        ans += stack.size
        return ans
    }

}