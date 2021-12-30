import java.util.*

class Solution20 {
    fun isValid(s: String): Boolean {
        val stack = ArrayDeque<Char>()

        s.forEach{
            if(it == '(' || it == '{' || it == '[')
                stack.push(it)
            else {
                val topOfStack = stack.pop()
                if(it == ')' && topOfStack!= '(') return false
                if(it == ']' && topOfStack!= '[') return false
                if(it == '}' && topOfStack!= '{') return false

            }
        }
        return stack.isEmpty()
    }
}

fun main() {
    val s = Solution20()
    s.isValid("()")
}