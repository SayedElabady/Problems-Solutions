package CTCI

import kotlin.concurrent.thread

//fun powerSet(array: IntArray, index: Int): MutableList<MutableList<Int>> {
//    val answer: MutableList<MutableList<Int>>
//    if (index == array.size) {
//        answer = mutableListOf()
//        answer.add(mutableListOf())
//    } else {
//        answer = powerSet(array, index + 1)
//        val extraSets = mutableListOf<MutableList<Int>>()
//        for (set in answer){
//            val temp = mutableListOf<Int>()
//            temp.addAll(set)
//            temp.add(array[index])
//            extraSets.add(temp)
//        }
//        answer.addAll(extraSets)
//    }
//    return answer
//}

fun powerSet(array: IntArray): MutableList<MutableList<Int>> {
    val answer = mutableListOf<MutableList<Int>>()
    val max = 1.shl(array.size)
    for (index in 0 until max) {
        answer.add(convertIntToSet(index, array))
    }
    return answer
}

fun convertIntToSet(number: Int, array: IntArray): MutableList<Int> {
    var index = 0
    val answer = mutableListOf<Int>()
    var current = number
    while (current != 0) {
        if (current.and(1) == 1) answer.add(array[index])
        current = current.shr(1)
        index++
    }
    return answer
}

fun main() {
    powerSet(intArrayOf(1, 2, 3))
}