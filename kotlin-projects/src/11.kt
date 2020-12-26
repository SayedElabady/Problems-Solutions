import kotlin.math.max
import kotlin.math.min

class SolutionS11 {
    fun maxArea(height: IntArray): Int {
        var l = 0
        var r = height.size - 1
        var ans = -1
        while (r - l >=1) {
            ans = max(ans, min(height[l], height[r]) * (r - l))
            if (height[l] > height[r])
                r--
            else l++
        }
        height
        return ans
    }

}

fun main() {
    val s = SolutionS11()
    s.maxArea(intArrayOf(1,1))
}