class Solution594 {
    fun findLHS(nums: IntArray): Int {
        val counts = HashMap<Int, Int>()
        nums.forEach {
            counts[it] = counts.getOrDefault(it, 0) + 1
        }
        var lastPair: Pair<Int, Int>? = null
        var answer = Int.MAX_VALUE
        counts.toSortedMap()
            .toList()
            .forEachIndexed { index, pair ->
                if (lastPair != null) {
                    if (pair.first - lastPair?.first!! == 1) {
                        answer = Math.max(answer, pair.second+lastPair!!.second)
                    }
                }
                lastPair = pair
            }
        return answer
    }
}