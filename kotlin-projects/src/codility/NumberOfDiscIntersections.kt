package codility

class NumberOfDiscIntersections {

    fun solution(A: IntArray): Int {
        val values: MutableList<Pair<Long, Long>> = mutableListOf()
        for (i in 0 until A.size) {
            values.add(Pair((i.toLong() - A[i].toLong()), (i.toLong() + A[i].toLong())))
        }
        var ans: Long = 0
        values.sortBy { it.first }
        for (iter in 0 until values.size) {
            var searchedValue = values.subList(iter + 1, values.size)
                .binarySearch {
                    (it.first - values[iter].second).toInt()
                }
            ans += if (searchedValue >= 0) {
                while (searchedValue + iter + 2 < values.size && values[searchedValue + iter + 2].first == values[iter].second) searchedValue++
                searchedValue + 1
            } else Math.abs(searchedValue) - 1
            if (ans > 10000000) return -1
        }
        return ans.toInt()
    }
}

fun main() {
    val s = NumberOfDiscIntersections()
    s.solution(intArrayOf(1, 2147483647, 0))
    s.solution(intArrayOf(1, 0, 1, 0, 1))
    s.solution(intArrayOf(1, 5, 2, 1, 4, 0))
    s.solution(intArrayOf(1, 1, 1))

}