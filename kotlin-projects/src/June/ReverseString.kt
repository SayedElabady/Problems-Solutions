package June

class ReverseString {
    fun reverseString(s: CharArray): Unit {
        var char = 's'
        for (i in 0 until s.size / 2) {
            char = s[i]
            s[i]=s[s.size - i - 1]
            s[s.size - i - 1] = char
        }
    }
}

fun main() {
    val s = ReverseString()
    val x=charArrayOf('h','e','f','l','o','h')
    s.reverseString(x)
}