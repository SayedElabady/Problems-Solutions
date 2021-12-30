package adventofcode

import kotlin.math.abs

class TheTreacheryofWhales {

//    fun theTreacheryofWhales(input: List<Int>): Int {
//        var answer = Int.MAX_VALUE
//        input.forEach { main ->
//            var sum = 0
//            input.forEach {
//                sum += abs(main - it)
//            }
//            answer = minOf(answer, sum)
//        }
//        return answer
//    }

    fun theTreacheryofWhales(input: List<Int>): Int {
        var answer = Int.MAX_VALUE
        val min = input.min()!!
        val max = input.max()!!

        for (iterator in min..max) {
            var sum = 0
            input.forEach {
                val abs = abs(iterator - it)
                sum += (abs * (abs + 1)) / 2
            }
            answer = minOf(answer, sum)
        }
        return answer
    }

}

fun main() {
    var line: String? = readLine()
    val list = mutableListOf<Int>()
    while (line != null && line.isNotEmpty()) {
        line.split(",").forEach {
            list.add(it.toInt())
        }
        line = readLine()
    }
    val s= TheTreacheryofWhales()
    println(s.theTreacheryofWhales(list))
}