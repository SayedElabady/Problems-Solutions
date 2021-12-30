package CTCI

import kotlin.math.min

fun minProduct(a: Int, b: Int): Int {
    val smaller = if (a > b) b else a
    val bigger = if (a < b) b else a

    val memo = IntArray(smaller + 1) { -1 }

    minProductHelper(smaller, bigger, memo)
    return memo[smaller]
}

fun minProductHelper(smaller: Int, bigger: Int, memo: IntArray): Int {
    when {
        smaller == 1 -> return bigger
        smaller == 0 -> return 0
        memo[smaller] != -1 -> return memo[smaller]
    }
    memo[smaller] = 0
    val half = smaller.shr(1)
    val firstSide = minProductHelper(half, bigger, memo)
    memo[smaller] = if (smaller % 2 == 0){
        firstSide + firstSide
    }else{
        firstSide + firstSide + bigger
    }
    return memo[smaller]
}

fun main() {
    println(minProduct(12,6))
}
