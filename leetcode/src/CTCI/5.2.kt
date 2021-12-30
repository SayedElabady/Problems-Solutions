package CTCI

fun binaryRep(number: Double): String {

    var fraction = 0.5
    var current = number
    var answer = "."
    while (current > 0.0) {
    if(answer.length > 32) return "ERROR"

        if (current >= fraction) {
            answer += "1"
            current -= fraction
        } else {
            answer+="0"
        }
        fraction /= 2
    }
    return answer
}

fun main() {
    println(binaryRep(0.625))
}