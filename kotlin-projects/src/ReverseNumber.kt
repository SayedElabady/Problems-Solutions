import java.lang.ArithmeticException

fun main() {
    val solution1 = Solution1()
    println(solution1.reverse(153))

}

class Solution1 {
    fun reverse(x: Int): Int {
        var ret = 0L
        var num = x
        while (num != 0) {
            if((10 * ret) + (num % 10) > Int.MAX_VALUE || (10 * ret) + (num % 10) < Int.MIN_VALUE)
                return 0
            ret = (10 * ret) + (num % 10)
            num /= (10)
        }
        return ret.toInt()
    }
}