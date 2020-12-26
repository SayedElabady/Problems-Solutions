package codility.canadaTest

class Second {
    fun solution(S: String): Int {
        val capitalOocurrences = IntArray(27)
        val smallOocurrences = IntArray(27)
        var smallest = Int.MAX_VALUE
        for (i in 0 until S.length - 1) {
            capitalOocurrences.fill(0)
            smallOocurrences.fill(0)
            if (S[i].isLowerCase()) smallOocurrences[S[i] - 'a'] = 1
            else if (S[i].isUpperCase()) capitalOocurrences[S[i] - 'A'] = 1
            for (j in i + 1 until S.length) {
                if (S[j].isLowerCase()) smallOocurrences[S[j] - 'a'] = 1
                else if (S[j].isUpperCase()) capitalOocurrences[S[j] - 'A'] = 1
                if (check(capitalOocurrences, smallOocurrences)) smallest = Math.min(smallest, j - i + 1)
            }
        }
        if (smallest == Int.MAX_VALUE) return -1
        return smallest
    }

    fun check(capitalOccurances: IntArray, smallOccurances: IntArray): Boolean {
        var foundOnAtLeast = false
        for (i in 0 until capitalOccurances.size) {
            if (capitalOccurances[i] == smallOccurances[i] && smallOccurances[i] == 1) {
                foundOnAtLeast = true
            } else if (smallOccurances[i] == 1 && capitalOccurances[i] != 1) return false
            else if (smallOccurances[i] != 1 && capitalOccurances[i] == 1) return false
        }
        return foundOnAtLeast
    }

}

fun main() {
    val s = Second()
    s.solution("azABaabza")
    s.solution("TacoCat")
    s.solution("AcZC")
    s.solution("azABaabza")

}