class Solution1366 {
    fun rankTeams(votes: Array<String>): String {
        val ranks = Array(27) { Pair(it, IntArray(votes[0].length)) }
        votes.forEach {
            it.forEachIndexed { index, char ->
                ranks[char - 'A'].second[index]++
            }
        }

        val answer = ranks.sortedArrayWith(
            Comparator { p0, p1 ->
                for (index in p0.second.indices) {
                    if (p0.second[index] != p1.second[index]) {
                        return@Comparator p1.second[index] - p0.second[index]
                    }
                }
                return@Comparator p0.first - p1.first
            }
        )
        return answer.map { it.first }.map { (it + 65).toChar() }.joinToString("").take(votes[0].length)
    }
}

fun main() {
    val s = Solution1366()
    print(s.rankTeams(arrayOf("ABC", "ABC", "ACB", "ACB", "ACB")))
}