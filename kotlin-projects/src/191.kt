class Solution191 {
    // you need treat n as an unsigned value
    fun hammingWeight(n: Int): Int {
        var number = if (n < 0) (n + 1 + Int.MAX_VALUE) else n
        var answer = 0
        while (number != 0) {
            answer ++
            number.and(number-1)
        }
        return answer
    }
}

fun main() {
    val s = Solution191()
    s.hammingWeight(-3)
}