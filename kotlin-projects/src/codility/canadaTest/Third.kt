package codility.canadaTest

class Third {
    fun solution(S: String, C: IntArray): Int {
        var i = 0
        var maxCount = Int.MIN_VALUE
        var totalCount = 0
        var ans = 0
        while (i < S.length) {
            maxCount = Int.MIN_VALUE
            totalCount = C[i]
            while (i + 1 < S.length && S[i] == S[i + 1]) {
                maxCount = Math.max(maxCount, Math.max(C[i], C[i + 1]))
                totalCount += C[i + 1]
                i++
            }
            if (maxCount != Int.MIN_VALUE) {
                ans += totalCount - maxCount
            }
            i++
        }
        return ans
    }
}


fun main() {
    val s = Third()
    s.solution("abccbd", intArrayOf(0, 1, 2, 3, 4, 5))
}