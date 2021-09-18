package HackerRank

fun anagram(s: String): Int {
    if (s.length % 2 != 0) return -1
    val firstString = s.substring(0, s.length / 2)
    var secondString = s.substring(s.length / 2 )
    var ans = 0
    for (c in firstString) {
        val foundIndex = secondString.indexOfFirst { it == c }
        if (foundIndex == -1)
            ans++
        else {
            secondString = secondString.substring(0, foundIndex) + secondString.substring(foundIndex + 1)
        }
    }
    return ans
}