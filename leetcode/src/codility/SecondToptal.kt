package codility

fun solution2(A: IntArray): Int {
    var sumSoFar = 0
    var answer = 0
    val negativeValues = mutableListOf<Int>()
    A.forEach {
        if (it < 0) negativeValues.add(it * -1)
        sumSoFar += it
        if (sumSoFar < 0) {
            val maxNegativeNumber = negativeValues.max() ?: 0
            sumSoFar += maxNegativeNumber
            answer++
            negativeValues.remove(maxNegativeNumber)
        }
    }
    return answer
}

fun main() {
    println(solution2(intArrayOf(10, -10, -1, -1, 10)))
}