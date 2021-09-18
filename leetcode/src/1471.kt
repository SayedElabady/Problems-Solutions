import kotlin.math.abs

class Solution1471 {
    fun getStrongest(arr: IntArray, k: Int): IntArray {
        var left = 0
        var right = arr.size - 1
        var count = k
        arr.sort()
        val median = arr[(arr.size - 1) / 2]
        val answer = mutableListOf<Int>()
        while (left != right && count != 0) {
            if (abs(arr[left] - median) > abs(arr[right] - median)) {
                answer.add(arr[left])
                left++
            } else if (abs(arr[left] - median) < abs(arr[right] - median)) {
                answer.add(arr[right])
                right--
            } else {
                if (arr[right] > arr[left]) {
                    answer.add(arr[right])
                    right--
                } else {
                    answer.add(arr[left])
                    left++
                }
            }
            count--
        }
        return answer.toIntArray()
    }

}

fun main() {
    val sl = Solution1471()
  sl.getStrongest(intArrayOf(1, 2, 3, 4, 5), 2).forEach { print(it) }
}