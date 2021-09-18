import java.util.*

class Solution1375 {
    fun numTimesAllBlue(light: IntArray): Int {
        val set = TreeSet<Int>()
        var result = 0
        light.forEachIndexed { index, item ->
            set.add(item)
            if (set.size == index + 1 && set.last() == index + 1) result++
        }
        return result
    }

    fun binarySearch(startIndex: Int, endIndex: Int, lightArray: BooleanArray): Int {
        var left = startIndex
        var right = endIndex
        while (right > left) {
            val mid = (right + left + 1) / 2
            if (lightArray[mid]) {
                left = mid
            } else {
                right = mid - 1
            }
        }
        return left
    }
}

fun main() {
    val solution = Solution1375()
//    println(solution.numTimesAllBlue(intArrayOf(2, 1, 3, 5, 4)))
//    println(solution.numTimesAllBlue(intArrayOf(3, 2, 4, 1, 5)))
//    println(solution.numTimesAllBlue(intArrayOf(4, 1, 2, 3)))
//    println(solution.numTimesAllBlue(intArrayOf(2, 1, 4, 3, 6, 5)))
//    println(solution.numTimesAllBlue(intArrayOf(1, 2, 6, 4, 5, 3)))
    println(
        solution.numTimesAllBlue(
            intArrayOf(
                1,
                2,
                3,
                4,
                5,
                7,
                6,
                8,
                9,
                27,
                11,
                12,
                13,
                14,
                18,
                16,
                17,
                15,
                19,
                20,
                21,
                22,
                10,
                23,
                25,
                26,
                24,
                28
            )
        )
    )

}