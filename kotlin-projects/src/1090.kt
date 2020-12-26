class Solution1090 {

    fun largestValsFromLabels(
        values: IntArray,
        labels: IntArray,
        num_wanted: Int,
        use_limit: Int
    ): Int {
        val taken = IntArray(20001)
        val pairValues = Array(values.size) {
            Pair(0, 0)
        }
        values.forEachIndexed { index, value ->
            pairValues[index] = Pair(value, labels[index])
        }
        pairValues.sortBy {
            it.first
        }
        var ans = 0
        var calculated = 0
        for (index in values.size - 1 downTo 0) {
            if (calculated >= num_wanted) break
            if (taken[pairValues[index].second] < use_limit) {
                ans += pairValues[index].first
                taken[pairValues[index].second]++
                calculated++
            }
        }
        return ans
    }
}

fun main() {
    val s = Solution1090()
    s.largestValsFromLabels(intArrayOf(5, 4, 3, 2, 1), intArrayOf(1, 1, 2, 2, 3), 3, 1)
    s.largestValsFromLabels(intArrayOf(5, 4, 3, 2, 1), intArrayOf(1, 3, 3, 3, 2), 3, 2)
    s.largestValsFromLabels(intArrayOf(9, 8, 8, 7, 6), intArrayOf(0, 0, 0, 1, 1), 3, 1)
    s.largestValsFromLabels(intArrayOf(9, 8, 8, 7, 6), intArrayOf(0, 0, 0, 1, 1), 3, 2)

}