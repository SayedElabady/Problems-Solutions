class Solution739 {
    fun dailyTemperatures(T: IntArray): IntArray {
        val finder = Array(101) {
            IntArray(T.size + 1) { -1 }
        }
        val size = T.size - 1
        for (counter in size - 1 downTo 0) {
            for (element in 30 until 101) {
                if (T[counter + 1] == element)
                    finder[element][counter + 1] = counter + 1
                if (finder[element][counter] == -1) {
                    if (finder[element][counter + 1] != -1)
                        finder[element][counter] = finder[element][counter + 1]
                }
            }
        }
        val ans = IntArray(T.size) { Int.MAX_VALUE }
        T.forEachIndexed { index, element ->
            for (searched in element + 1 until 101) {
                if (finder[searched][index] != -1) {
                    ans[index] = kotlin.math.min(finder[searched][index] - index, ans[index])
                }
            }
        }
        for (t in ans.indices) {
            if (ans[t] == Int.MAX_VALUE) ans[t] = 0
        }
        return ans
    }

}

fun main() {

    val s = Solution739()
    s.dailyTemperatures(intArrayOf(73, 74, 75, 71, 69, 72, 76, 73))
}