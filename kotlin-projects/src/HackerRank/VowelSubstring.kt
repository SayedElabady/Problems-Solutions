package HackerRank

// Basically we split the possible range of vowels candidates,
// then we calculate if this is possible by using accumlative sums arrays for each vowel char

fun vowelsubstring(s: String): Int {
    val splitedStrings = mutableListOf<IntRange>()
    val lastNonVowel = -1
    val occ = IntArray(28)
    s.forEachIndexed { index, c ->
        occ[c - 'a']++
        if (!isVowel(c) && index - lastNonVowel >= 5)
            splitedStrings.add(IntRange(lastNonVowel + 1, index))
    }
    var ans = 0
    splitedStrings.forEach {

    }
    return ans
}

fun check(s: String, range: IntRange, occ: IntArray) {

}

fun isVowel(c: Char): Boolean {
    return c == 'a' && c == 'e' && c == 'i' && c == 'o' && c == 'u'
}

fun main(args: Array<String>) {
    val s = readLine()!!

    val result = vowelsubstring(s)

    println(result)
}
