class RLEIterator(val A: IntArray) {

    var current = 0
    var currentLeft = A[current]
    fun next(n: Int): Int {
        var nLeft = n
        while (true) {
            if (current >= A.size || current + 1 >= A.size) return -1
            when {
                currentLeft - nLeft > 0 -> {
                    currentLeft -= nLeft
                    return A[current + 1]
                }
                currentLeft - nLeft == 0 -> {
                    current += 2
                    currentLeft = if (current < A.size) A[current] else -1
                    return A[current - 1]
                }
                else -> {
                    nLeft -= currentLeft
                    current += 2
                    currentLeft = if (current < A.size) A[current] else -1
                }
            }
        }

    }

}

fun main() {
    val rleIterator = RLEIterator(intArrayOf(3, 8, 0, 9, 2, 5))
    println(rleIterator.next(2))
    println(rleIterator.next(1))
    println(rleIterator.next(1))
    println(rleIterator.next(1))
    println(rleIterator.next(2))
}