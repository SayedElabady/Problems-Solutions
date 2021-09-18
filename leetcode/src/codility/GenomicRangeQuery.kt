package codility

class GenomicRangeQuery {

    fun solution(S: String, P: IntArray, Q: IntArray): IntArray {
        val sum = Array(4) { IntArray(S.length) }
        when {
            S[0] == 'A' -> sum[0][0] = 1
            S[0] == 'C' -> sum[1][0] = 1
            S[0] == 'G' -> sum[2][0] = 1
            else -> sum[3][0] = 1
        }
        for (i in 1 until S.length) {
            sum[0][i] += sum[0][i - 1] + if (S[i] == 'A') 1 else 0
            sum[1][i] += sum[1][i - 1] + if (S[i] == 'C') 1 else 0
            sum[2][i] += sum[2][i - 1] + if (S[i] == 'G') 1 else 0
            sum[3][i] += sum[3][i - 1] + if (S[i] == 'T') 1 else 0
        }
        val ans = IntArray(P.size)
        for (i in 0 until P.size) {
            if (P[i] == 0)
                ans[i] = when {
                    sum[0][Q[i]] > 0 -> 1
                    sum[1][Q[i]] > 0 -> 2
                    sum[2][Q[i]] > 0 -> 3
                    else -> 4
                }
            else
                ans[i] = when {
                    sum[0][Q[i]] - sum[0][P[i] - 1] > 0 -> 1
                    sum[1][Q[i]] - sum[1][P[i] - 1] > 0 -> 2
                    sum[2][Q[i]] - sum[2][P[i] - 1] > 0 -> 3
                    else -> 4
                }
        }
        return ans
    }
}

fun main() {
    val s = GenomicRangeQuery()
    s.solution("CAGCCTA", intArrayOf(2, 5, 0), intArrayOf(4, 5, 6))
}