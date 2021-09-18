package Algo1

class Solution557 {
    fun reverseWords(s: String): String {
        val splitWords = s.split(" ")
        val result = Array(splitWords.size) { "" }
        splitWords.forEachIndexed { index, word -> result[index] = word.reversed() }

       return result.joinToString(" ")
    }
}