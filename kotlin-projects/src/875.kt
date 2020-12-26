class Solution875 {

    fun minEatingSpeed(piles: IntArray, H: Int): Int {
        var l = 1
        var r = piles.max()!!
        while (r > l) {
            val mid = (r + l) / 2
            if (check(piles, mid, H)) {
                r = mid
            } else l = mid + 1
        }
        return r
    }

    fun check(piles: IntArray, count: Int, hoursCount: Int): Boolean {
        var hoursNeeded = 0
        for (pile in piles) {
            hoursNeeded += pile / count
            if (pile % count != 0) hoursNeeded++
            if (hoursNeeded > hoursCount)
                return false
        }
        return true
    }

}

fun main() {
    val s = Solution875()
    println(s.minEatingSpeed(intArrayOf(3, 6, 7, 11), 8))
    println(s.minEatingSpeed(intArrayOf(30, 11, 23, 4, 20), 5))
    println(s.minEatingSpeed(intArrayOf(30, 11, 23, 4, 20), 6))

}