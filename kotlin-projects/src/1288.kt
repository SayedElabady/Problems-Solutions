class Solution1288 {
    fun removeCoveredIntervals(intervals: Array<IntArray>): Int {
        val removed = BooleanArray(intervals.size)
        for (index in 0 until intervals.size) {
            if (removed[index]) continue
            for (innerIndex in index + 1 until intervals.size) {
                if (removed[innerIndex]) continue
                if (intervals[index][0] <= intervals[innerIndex][0] && intervals[index][1] >= intervals[innerIndex][1]) {
                    removed[innerIndex] = true
                }
                if (intervals[index][0] >= intervals[innerIndex][0] && intervals[index][1] <= intervals[innerIndex][1]) {
                    removed[index] = true
                }
            }
        }
        return removed.count { !it }
    }
}

fun main() {
    val s = Solution1288()
    println(s.removeCoveredIntervals(arrayOf(intArrayOf(0, 10), intArrayOf(5, 12))))
    println(s.removeCoveredIntervals(arrayOf(intArrayOf(1, 4), intArrayOf(2, 3))))

}