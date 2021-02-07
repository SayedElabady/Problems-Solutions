class Solution621 {
    fun leastInterval(tasks: CharArray, n: Int): Int {
        val charsCount = IntArray(28)
        tasks.forEach { charsCount[it - 'A']++ }
        charsCount.sort()
        val maxFreq = charsCount[0]
        var gaps = (maxFreq - 1) * n
        for (index in 25 downTo 1) {
            gaps -= Math.min(maxFreq - 1, charsCount[index])
        }
        return if (gaps < 0) tasks.size else gaps + tasks.size
    }
}

fun main() {
    val s = Solution621()
    println(s.leastInterval(charArrayOf('A', 'A', 'A', 'B', 'B', 'B'), 0))
    println(s.leastInterval(charArrayOf('E', 'E', 'E', 'B', 'B', 'B', 'C', 'C', 'C', 'D', 'D', 'A'), 2))

}