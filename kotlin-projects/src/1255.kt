import kotlin.math.max

fun main() {
    val s = Solution1255()
    print(
        s.maxScoreWords(
            arrayOf("azb","ax","awb","ayb","bpppp"),
            charArrayOf('z','a','w','x','y','b','p','p','p'),
            intArrayOf(10,1,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,3,2,3,3)
        )
    )
}

class Solution1255 {
    fun maxScoreWords(words: Array<String>, letters: CharArray, score: IntArray): Int {
        var remaining = IntArray(28) { 0 }
        for (i in 0 until letters.size)
            remaining[letters[i] - 'a']++
        return solve(0, words, remaining, score, 0)
    }

    private fun solve(index: Int, words: Array<String>, remaining: IntArray, score: IntArray, totalSum: Int): Int {
        if (index == words.size) return totalSum
        var _totalSum = totalSum

        var notApplicable = false
        var skipCurrent = solve(index + 1, words, remaining, score, totalSum)
        for (i in 0 until words[index].length) {
            remaining[words[index][i] - 'a']--
            _totalSum += score[words[index][i] - 'a']
        }
        for (i in 0 until remaining.size)
            if (remaining[i] < 0)
                notApplicable = true
        if (notApplicable) return skipCurrent

        var withCurrent = solve(index + 1, words, remaining, score, _totalSum)
        for (i in 0 until words[index].length) {
            remaining[words[index][i] - 'a']++
        }
        return max(max(withCurrent, skipCurrent) , _totalSum)
    }
}