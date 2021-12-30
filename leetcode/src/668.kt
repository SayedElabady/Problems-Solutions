import kotlin.math.max
import kotlin.math.min

class Solution668 {
    fun findKthNumber(m: Int, n: Int, k: Int): Int {
        var left = 1
        var right = m * n
        while (right > left){
            val mid = left + (right - left) / 2
            if(isValid(mid, m, n, k)){
                right = mid
            }else left = mid + 1
        }
    return left
    }

    fun isValid(number: Int, m: Int, n: Int, k: Int): Boolean {
        var count = 0
        for (iterator in 1..m) {
            count += min(number / iterator, n)
        }
        return count >= k
    }
}

fun main() {
    val s = Solution668()
    s.findKthNumber(2, 4, 6)
}