package codility

fun solutionDemo(A: IntArray): Int {
    // write your code in Kotlin 1.3.11 (Linux)
    A.sort()
    val numbers = mutableListOf<Int>()
    A.forEach {
        if (it > 0) {
            if (numbers.isEmpty() || numbers.last() != it)
                numbers.add(it)
        }
    }
    var currentNumber = 1
    numbers.forEach {
        if (it > 0) {
            if (it != currentNumber) return currentNumber
            currentNumber++
        }
    }
    if (numbers.last() <= 0) return 1
    return numbers.last() + 1
}

fun main() {
    print(solutionDemo(intArrayOf(-2, -1, 1, 3)))
}