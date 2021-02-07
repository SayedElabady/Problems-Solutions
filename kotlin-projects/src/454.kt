class Solution454 {

    fun fourSumCount(A: IntArray, B: IntArray, C: IntArray, D: IntArray): Int {

        val map = HashMap<Int, Int>()
        for (x in A) {
            for (y in B) {
                map[(x + y)] = map.getOrDefault((x + y), 0) + 1
            }
        }

        var answer = 0
        for (x in C) {
            for (y in D) {
               answer += map.getOrDefault(-(x + y), 0)
            }
        }
        return answer
    }

}

fun main() {
    val s = Solution454()
    s.fourSumCount(intArrayOf(0, 1, -1), intArrayOf(-1, 1, 0), intArrayOf(0, 0, 1), intArrayOf(-1, 1, 1))

}