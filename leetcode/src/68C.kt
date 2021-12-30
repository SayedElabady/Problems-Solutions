import java.util.*

class Solution68C {

//    fun canBeValid(s: String, locked: String): Boolean {
//        val stack = Stack<Pair<Char, Int>>()
//        for (index in s.length - 1 downTo 0) {
//            val it = s[index]
//            if (it == '(') {
//                stack.push('(' to index)
//            } else {
//                if (stack.isNotEmpty()) {
//                    stack.pop()
//                } else {
//                    if (locked[index] == '1') return false
//                    else stack.push('(' to index)
//                }
//            }
//        }
//        if (stack.isEmpty()) return true
//        if (stack.size % 2 == 1) return false
//        for (index in 0 until stack.size / 2) {
//            if (locked[stack.peek().second] == '1') {
//                return false
//            } else {
//                stack.pop()
//                stack.pop()
//            }
//        }
//        return true
//    }

    fun canBeValid(s: String, locked: String): Boolean {
        var stack = Stack<Pair<Char, Int>>()
        var answer = true
        for (index in s.length - 1 downTo 0) {
            val it = s[index]
            if (it == '(') {
                stack.push('(' to index)
            } else {
                if (stack.isNotEmpty()) {
                    stack.pop()
                } else {
                    if (locked[index] == '1'){
                        answer = false
                        break
                    }
                    else stack.push('(' to index)
                }
            }
        }
        if (stack.isEmpty()) return true
        if (stack.size % 2 == 1){answer = false}
        for (index in 0 until stack.size / 2) {
            if (locked[stack.peek().second] == '1') {
                answer = false
            } else {
                stack.pop()
                stack.pop()
            }
        }
        if(answer == false){
            stack = Stack<Pair<Char, Int>>()
            for (index in 0 until s.length) {
                val it = s[index]
                if (it == '(') {
                    stack.push('(' to index)
                } else {
                    if (stack.isNotEmpty()) {
                        stack.pop()
                    } else {
                        if (locked[index] == '1'){
                            answer = false
                            break
                        }
                        else stack.push('(' to index)
                    }
                }
            }
            if (stack.isEmpty()) return true
            if (stack.size % 2 == 1) return false
            for (index in 0 until stack.size / 2) {
                if (locked[stack.peek().second] == '1') {
                    return false
                } else {
                    stack.pop()
                    stack.pop()
                }
            }
            return true
        }
        return true
    }

}

fun main() {
    val s = Solution68C()
    //s.canBeValid("(" )
}