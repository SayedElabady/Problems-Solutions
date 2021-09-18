package HackerRank

import kotlin.math.max

val mim = Array(101) {
    IntArray(30001) { -1 }
}

fun selectStock(saving: Int, currentValue: Array<Int>, futureValue: Array<Int>): Int {
    return check(saving, currentValue, futureValue, 0, 0)

}

fun check(saving: Int, currentValue: Array<Int>, futureValue: Array<Int>, currentIndex: Int, gain: Int): Int {
    var takeMe: Int = Int.MIN_VALUE
    if (mim[currentIndex][gain] != -1) return mim[currentIndex][gain]
    if (currentIndex >= currentValue.size) return gain
    if (saving >= currentValue[currentIndex] && futureValue[currentIndex] > currentValue[currentIndex])
        takeMe = check(
            saving - currentValue[currentIndex],
            currentValue,
            futureValue,
            currentIndex + 1,
            gain + futureValue[currentIndex] - currentValue[currentIndex]
        )
    val dontTakeMe = check(saving, currentValue, futureValue, currentIndex + 1, gain)
    mim[currentIndex][gain] = max(max(takeMe, dontTakeMe), gain)
    return mim[currentIndex][gain]

}

fun main(args: Array<String>) {
    val saving = readLine()!!.trim().toInt()

    val currentValueCount = readLine()!!.trim().toInt()

    val currentValue = Array<Int>(currentValueCount, { 0 })
    for (i in 0 until currentValueCount) {
        val currentValueItem = readLine()!!.trim().toInt()
        currentValue[i] = currentValueItem
    }

    val futureValueCount = readLine()!!.trim().toInt()

    val futureValue = Array<Int>(futureValueCount, { 0 })
    for (i in 0 until futureValueCount) {
        val futureValueItem = readLine()!!.trim().toInt()
        futureValue[i] = futureValueItem
    }

    val result = selectStock(saving, currentValue, futureValue)

    println(result)
}