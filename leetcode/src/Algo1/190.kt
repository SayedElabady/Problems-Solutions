package Algo1

import java.lang.Math.pow

class Solution190 {
    // you need treat n as an unsigned value
    fun reverseBits(n: Int): Int {
        val bitsString = Integer.toBinaryString(n)
        var zeroes = ""
        (bitsString.length until 32).forEach { zeroes += "0" }
        val resString = "$zeroes$bitsString"
        var result = 0
        var mult = 0
        resString.forEachIndexed { index, it ->

            if (it == '1')
                result += pow(2.0, index.toDouble()).toInt()
        }
        if (result < 0) result += Int.MAX_VALUE
        return result
    }
}

fun main() {
    val s = Solution190()
    s.reverseBits(4294967293.toInt())
}