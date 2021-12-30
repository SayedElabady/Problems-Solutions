class Solution1153 {
    fun canConvert(str1: String, str2: String): Boolean {
        val replaces = HashMap<Char, Char>()
        str1.forEachIndexed { index, it ->
            if (!replaces.contains(it)) {
                replaces[it] = str2[index]
            } else if (replaces[it] != str2[index] || replaces[str2[index]] == it) {
                return false
            }
        }
        return true
    }
}

fun main() {
    val s = Solution1153()
    s.canConvert("abcdefghijklmnopqrstuvwxyz", "bcdefghijklmnopqrstuvwxyza")
}