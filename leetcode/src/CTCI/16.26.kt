package CTCI

import java.lang.StringBuilder

fun calculate(string: String): Int {
    val formattedString = string.filter { !it.isWhitespace() }
    val toBeProcceed = if (formattedString[0].isDigit()) "+".plus(formattedString)
    else formattedString
    var processing = 0L
    var answer = 0L
    var index = 0
    val tempStringBuilder = StringBuilder()
    while (index < toBeProcceed.length - 1) {
        val operator = toBeProcceed[index++]
        while (index < toBeProcceed.length && toBeProcceed[index].isDigit()){
            tempStringBuilder.append(toBeProcceed[index])
            index++
        }
        val current = when (operator) {
            Operatators.Multiply.value -> if (processing == 0L) {
                tempStringBuilder.toString().toLong()
            } else {
                tempStringBuilder.toString().toLong() * processing
            }
            Operatators.Divide.value -> if (processing == 0L) {
                tempStringBuilder.toString().toLong()
            } else {
                processing / tempStringBuilder.toString().toLong()
            }
            Operatators.Add.value ->
                tempStringBuilder.toString().toLong() + processing
            else ->
                (-1 *tempStringBuilder.toString().toLong()) - processing
        }
        if (index  < toBeProcceed.length &&
            (toBeProcceed[index] == Operatators.Multiply.value || toBeProcceed[index] == Operatators.Divide.value)
        ) {
          processing = current
        } else {
            answer += current
            processing= 0
        }
        tempStringBuilder.setLength(0)
    }
    return answer.toInt()
}

enum class Operatators(val value: Char) {
    Add('+'), Substract('-'), Multiply('*'), Divide('/')
}

fun main() {
    calculate(" 2-6-7*80 ")
}