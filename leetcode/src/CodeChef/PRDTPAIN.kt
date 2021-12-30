package CodeChef

import kotlin.math.max

class PRDTPAIN {

    fun search(intArray: IntArray): Long {
        var answer = -1L
        for (index in 1 until intArray.size - 1) {
            answer = max(
                answer,
                (intArray.first() - intArray[index]).toLong() * (intArray[index] - intArray.last()).toLong()
            )
        }
        return answer
    }
}

fun main() {
    val ds = PRDTPAIN()
    ds.search(intArrayOf(1, 42, 69, 228, 2021))
}