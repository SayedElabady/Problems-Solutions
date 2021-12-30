package codility

import kotlin.math.max

fun solution(S: String, C: String): Int {
    val tableLines = S.split("\n")
    val targetIndex = tableLines[0].split(",").indexOf(C)

    var answer = Int.MIN_VALUE

    (1 until tableLines.size).forEach {
        answer = max(answer, tableLines[it].split(",")[targetIndex].toInt())
    }

    return answer
}

fun main() {
    println(solution("city,temp2,temp\nParis,7,-3\nPorto,-1,-2", "temp"))
}