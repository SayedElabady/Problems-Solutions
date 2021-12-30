import java.util.*

class Solution394 {
    fun decodeString(s: String): String {
        val stack = Stack<Char>()
        val answer = StringBuilder()
        val iterations = Stack<Int>()
        var index = 0
        while(index < s.length){
            if(s[index].isDigit()){
                var number = 0
                while(s[index].isDigit()){
                    number = number * 10 + s[index].toString().toInt()
                }
                iterations.push(number)
            }else{
                if(stack.isEmpty() && s[index] != '['){
                    answer.append(s[index])
                }else{
                    if(s[index] == ']'){
                        val polledString = getCurrentIteration(iterations.pop(), stack)
                        if(stack.isEmpty()){
                            answer.append(polledString)
                        }else{
                            polledString.forEach{
                                stack.push(it)
                            }
                        }
                    }else{
                        stack.push(s[index])
                    }
                }
            }
        }
        if(stack.isNotEmpty())
            answer.append(getCurrentIteration(1, stack))
        return answer.toString()
    }

    fun getCurrentIteration(iteration: Int, stack: Stack<Char>): StringBuilder{
        val temp = StringBuilder()
        val answer = StringBuilder()
        while(stack.peek() != '['){
            temp.append(stack.pop())
        }
        stack.pop()
        temp.reverse()
        for(i in 0 until iteration){
            answer.append(temp)
        }
        return answer
    }
}

fun main() {
    val s = Solution394()
    s.decodeString("100[leetcode]")
}