fun main() {
    val s = Solution763()
    println(s.partitionLabels("eaaaabaaec"))
}

class Solution763 {

    fun partitionLabels(S: String): List<Int> {
        val original = Array(27) { 0 }
        val editable = Array(27) { 0 }
        for (char in S) {
            original[char - 'a']++
            editable[char - 'a']++
        }
        val ret = mutableListOf<Int>()
        var start = 0
        for (i in 0 until S.length) {
            editable[S[i] - 'a']--
            if (check(original, editable)) {
                ret.add(i - start + 1)
                start = i + 1
            }

        }
        return ret
    }

    fun check(original: Array<Int>, updated: Array<Int>): Boolean {
        for (i in 0 until original.size) {
            if (original[i] != updated[i] && updated[i] != 0) return false
        }
        return true
    }
}