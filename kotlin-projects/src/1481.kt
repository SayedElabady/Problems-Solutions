class Solution1481 {
    fun findLeastNumOfUniqueInts(arr: IntArray, k: Int): Int {
        val occurrences = HashMap<Int, Int>()
        arr.forEach {
            occurrences[it] = occurrences.getOrDefault(it, 0) + 1
        }
        var total = occurrences.size
        var left = k
        occurrences.toList()
            .sortedBy { (key, value) -> value }
            .forEach {
                if (it.second < left) {
                    total--
                    left -= it.second
                }
            }
        return total
    }
}

fun main() {
    val s = Solution1481()
    s.findLeastNumOfUniqueInts(intArrayOf(4, 3, 1, 1, 3, 3, 2), 3)
}