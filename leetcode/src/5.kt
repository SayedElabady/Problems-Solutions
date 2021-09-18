fun main() {
    val s = Solutions5()
    s.longestPalindrome("babad")


}

class Solutions5 {

    fun longestPalindrome(s: String): String {
        var maxLength = 1
        var start = 0
        val anss = Array<BooleanArray>(s.length) {
            BooleanArray(s.length) { false }
        }
        for (i in 0 until s.length)
            anss[i][i] = true

        for (i in 0..s.length - 2) {
            if (s[i] == s[i + 1]) {
                start = i
                maxLength = 2
                anss[i][i + 1] = true
            }
        }
        val length = s.length
        for (count in 3..length) {
            for (i in 0 until length - count + 1) {
                val comparingIndex = i + count - 1
                if (s[i] == s[comparingIndex] && anss[i + 1][comparingIndex - 1]) {
                    anss[i][comparingIndex] = true
                    start = i
                    maxLength = count
                }
            }
        }
        return s.substring(start, start + maxLength )
    }
}