package CTCI

fun findSquaredMatrix(array: Array<IntArray>, target: Int): Pair<Int, Int> {
    var row = array.size - 1
    var column = 0
    while (row >= 0 && column < array[0].size) {
        if (array[row][column] == target) {
            return row to column
        } else if (array[row][column] < target) {
            column++
        } else {
            row--
        }
    }
    return -1 to -1
}

fun main() {
    println(findSquaredMatrix(
        arrayOf(
            intArrayOf(15, 20, 40, 50),
            intArrayOf(20, 35, 80, 95),
            intArrayOf(30, 50, 90, 105),
            intArrayOf(40, 80, 100, 120)
        )
    ,95 ))
}