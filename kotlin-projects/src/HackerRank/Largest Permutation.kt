package HackerRank

import java.io.*
import java.math.*
import java.security.*
import java.text.*
import java.util.*
import java.util.concurrent.*
import java.util.function.*
import java.util.regex.*
import java.util.stream.*
import kotlin.collections.*
import kotlin.comparisons.*
import kotlin.io.*
import kotlin.jvm.*
import kotlin.jvm.functions.*
import kotlin.jvm.internal.*
import kotlin.ranges.*
import kotlin.sequences.*
import kotlin.text.*

// Complete the largestPermutation function below.
fun largestPermutation(k: Int, arr: Array<Int>): Array<Int> {
    val size = arr.size
    val positions = IntArray(size + 1)

    arr.forEachIndexed { index, i ->
        positions[i] = index
    }
    var position = 0
    var limit = k
    while (true) {
        if (limit == 0 || position == size - 1) break
        if (arr[position] == size - position) {
            position++
            continue
        }
        arr[positions[size - position]] = arr[position]
        positions[arr[position]] = positions[size - position]
        arr[position] = size - position
        limit--
        position++
    }
    return arr
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val nk = scan.nextLine().split(" ")

    val n = nk[0].trim().toInt()

    val k = nk[1].trim().toInt()

    val arr = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    val result = largestPermutation(k, arr)

    println(result.joinToString(" "))
}
