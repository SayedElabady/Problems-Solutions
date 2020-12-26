package HackerRank

fun twoStrings(s1: String, s2: String): String {
    val oc = Array<Int>(27){0}
    for (char in s1)
        oc[char - 'a'] = 1
    for (c in s2)
        if(oc[c-'a'] > 0) return "YES"
    return "NO"
}