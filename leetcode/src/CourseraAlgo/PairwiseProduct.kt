package CourseraAlgo

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStream
import java.io.InputStreamReader
import java.util.*

fun getMaxPairwiseProduct(numbers: IntArray): Long {
    numbers.sort()
    val size = numbers.size
    return (numbers[size - 1].toLong() * numbers[size - 2].toLong())
}

fun main() {
    val scanner = FastScanner(System.`in`)
    val n = scanner.nextInt()
    val numbers = IntArray(n)
    for (i in 0 until n) {
        numbers[i] = scanner.nextInt()
    }
    //println(getMaxPairwiseProduct(numbers))
    println(getMaxPairwiseProduct(numbers))
}

class FastScanner(stream: InputStream) {
    var br: BufferedReader = BufferedReader(InputStreamReader(stream))
    var st: StringTokenizer? = null

    fun next(): String {
        while (st == null || !st!!.hasMoreTokens()) {
            try {
                st = StringTokenizer(br.readLine())
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
        return st!!.nextToken()
    }

    fun nextInt() = next().toInt()
}