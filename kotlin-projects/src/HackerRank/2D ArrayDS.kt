package HackerRank

fun main() {
    val f = arrayOf(-9, -9, -9, 1, 1, 1)
    val f1 = arrayOf(0, -9, 0, 4, 3, 2)
    val f2 = arrayOf(-9, -9, -9, 1, 2, 3)
    val f3 = arrayOf(0, 0, 8, 6, 6, 0)
    val f4 = arrayOf(0, 0, 0, -2, 0, 0)
    val f5 = arrayOf(0, 0, 1, 2, 4, 0)
   println( hourglassSum(arrayOf(f,f1,f2,f3,f4,f5)))
}

fun hourglassSum(arr: Array<Array<Int>>): Int {
    var max = Int.MIN_VALUE
    for (x in 1 until arr.size - 1) {
        for (y in 1 until arr[0].size - 1) {
            max = kotlin.math.max(max, getHourGlassSum(arr, x, y))
        }
    }
    return max
}

fun getHourGlassSum(arr: Array<Array<Int>>, x: Int, y: Int): Int {
    return arr[x][y] + arr[x - 1][y] + arr[x - 1][y - 1] + arr[x - 1][y + 1] + arr[x + 1][y] + arr[x + 1][y - 1] + arr[x + 1][y + 1]
}