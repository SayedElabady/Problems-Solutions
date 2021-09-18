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
import kotlin.math.min
import kotlin.ranges.*
import kotlin.sequences.*
import kotlin.text.*

// Complete the makeAnagram function below.
fun makeAnagram(a: String, b: String): Int {
    val firstChars = IntArray(27)
    val secondChars = IntArray(27)
    a.forEach { firstChars[it - 'a']++ }
    b.forEach { secondChars[it - 'a']++ }
    var similar = 0
    firstChars.forEachIndexed { index, num ->
        similar += min(num, secondChars[index]) * 2
    }
    return a.length + b.length - similar
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val a = scan.nextLine()

    val b = scan.nextLine()

    val res = makeAnagram(a, b)

    println(res)
}
