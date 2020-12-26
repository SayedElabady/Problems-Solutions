package codility

class BinaryGap {

    fun solution(N: Int): Int {
        var ans = 0
        var curr = -1
        var num = N
        while (num != 0) {
            if (num % 2 == 0 && curr != -1) curr++
            else if(num % 2 == 1) {
                ans = Math.max(ans, curr)
                curr = 0
            }
            num /= 2
        }
        return ans
    }
}

fun main() {
    val s = BinaryGap()
    print(s.solution(20 ))
}