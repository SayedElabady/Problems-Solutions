package adventofcode

import java.util.*
import kotlin.collections.HashMap

class SyntaxScoring {

    //    fun syntaxScoring(input: List<String>): Int{
//        val values = HashMap<Char, Int>()
//        values[')'] = 3
//        values[']'] = 57
//        values['}'] = 1197
//        values['>'] = 25137
//        var answer = 0
//        input.forEach {
//            val stack = Stack<Char>()
//            it.forEach {
//                if(it==')'){
//                    if(stack.peek() != '(') answer+=values[it]!!
//                    stack.pop()
//                }else if(it=='}'){
//                    if(stack.peek() != '{') answer+=values[it]!!
//                    stack.pop()
//                }else if(it==']'){
//                    if(stack.peek() != '[') answer+=values[it]!!
//                    stack.pop()
//                }else if(it=='>'){
//                    if(stack.peek() != '<') answer+=values[it]!!
//                    stack.pop()
//                }else{
//                    stack.push(it)
//                }
//            }
//        }
//        return answer
//    }
    fun syntaxScoring(input: List<String>): Long {
        val values = HashMap<Char, Int>()
        values[')'] = 1
        values[']'] = 2
        values['}'] = 3
        values['>'] = 4
        val total = mutableListOf<Long>()
        input.forEach {
            val stack = Stack<Char>()
            var answer = 0L
            var corrupted = false
            it.forEach {
                when (it) {
                    ')' -> {
                        if (stack.peek() != '(') corrupted = true
                        stack.pop()
                    }
                    '}' -> {
                        if (stack.peek() != '{') corrupted = true
                        stack.pop()
                    }
                    ']' -> {
                        if (stack.peek() != '[') corrupted = true
                        stack.pop()
                    }
                    '>' -> {
                        if (stack.peek() != '<') corrupted = true
                        stack.pop()
                    }
                    else -> stack.push(it)
                }
            }
            if (!corrupted) {
                while (stack.isNotEmpty()) {
                    when (stack.pop()) {
                        '(' -> {
                            answer =  (answer * 5) + values[')']!!
                        }
                        '[' -> {
                            answer =  (answer * 5) + values[']']!!
                        }
                        '{' -> {
                            answer =  (answer * 5) + values['}']!!
                        }
                        '<' -> {
                            answer =  (answer * 5) + values['>']!!
                        }
                    }
                }
                total.add(answer)
            }
        }
        total.sort()
        return total[total.size / 2]
    }
}

    fun main() {
        var line: String? = readLine()
        val list = mutableListOf<String>()
        while (line != null && line.isNotEmpty()) {
            list.add(line)
            line = readLine()
        }
        val s = SyntaxScoring()
        println(s.syntaxScoring(list))
    }
