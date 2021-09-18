fun main() {
    val s = Solution791()
    println(
        s.customSortString(
            "hucw",
            "utzoampdgkalexslxoqfkdjoczajxtuhqyxvlfatmptqdsochtdzgypsfkgqwbgqbcamdqnqztaqhqanirikahtmalzqjjxtqfnh"
        )
    )
}

class Solution791 {
    fun customSortString(S: String, T: String): String {
        val occurrences = Array(27) { 0 }
        for (char in T)
            occurrences[char - 'a']++
        var ret = ""
        for (sorted in S) {
            if (occurrences[sorted - 'a'] > 0) {
                for (i in 0 until occurrences[sorted - 'a']) ret += sorted
                occurrences[sorted - 'a'] = 0
            }
        }
        for (char in T)
            if (occurrences[char - 'a'] > 0) {
                for (i in 0 until occurrences[char - 'a'])
                    ret += char
                occurrences[char - 'a'] = 0
            }
        return ret
    }

}