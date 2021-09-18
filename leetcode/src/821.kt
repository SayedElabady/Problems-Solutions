class Solution821 {
    fun shortestToChar(s: String, c: Char): IntArray {
        var lastC = s.indexOfLast { it == c }
        val endNearestChar = IntArray(s.length) { lastC }

        for (i in s.length - 1 downTo 0) {
            if (s[i] == c) lastC = i
            endNearestChar[i] = lastC
        }
        lastC = s.indexOfFirst { it == c }
        val startNearestChar = IntArray(s.length) { lastC }
        for (i in 0 until s.length) {
            if (s[i] == c) lastC = i
            startNearestChar[i] = lastC
        }
        return endNearestChar.mapIndexed { index, i ->
            Math.min(Math.abs(index - i), Math.abs(index - startNearestChar[index]))
        }.toIntArray()
    }
}