import java.util.*
import kotlin.properties.Delegates

class Solution856 {
    fun scoreOfParentheses(S: String): Int {
        val charSack = Stack<Char>()
        var answer = 0
        print(answer.toString())
        S.forEach {
            if (it == ')') {
                var streak = 0
                while (charSack.isNotEmpty() && charSack.peek() == '(') {
                    answer += Math.max(1, 2 * streak)
                    streak++
                    charSack.pop()
                }
            }else charSack.push(it)
        }
        return answer
    }
}

fun main() {
    val s = Solution856()
    val ss = "I have a cheese"
    print("$ss.length")
    s.scoreOfParentheses("ss")

}
