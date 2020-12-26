class Solution69 {

    fun mySqrt(x: Int): Int {
        var l: Long = 1
        var r: Long = x.toLong()
        val longedValue = x.toLong()
        var ans : Long = -1
        while (r >= l) {
            val mid: Long = l + (r - l) / 2
            when {
                mid * mid == longedValue -> return mid.toInt()
                mid * mid > longedValue -> r = mid - 1
                mid * mid < longedValue -> {
                    l = mid + 1
                    ans = Math.max(ans, mid)
                }
            }
        }
        return ans.toInt()
    }
}

fun main() {
    val s = Solution69()
    s.mySqrt(2147395599)
}