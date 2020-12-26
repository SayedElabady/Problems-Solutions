package June

import kotlin.math.abs

class TwoCityScheduling {
    fun twoCitySchedCost(costs: Array<IntArray>): Int {
        val list = Array(costs.size) { index -> Triple(0, 0, index) }
        for (i in 0 until costs.size) {
            list[i] = Triple(costs[i][0], costs[i][1], abs(costs[i][0] - costs[i][1]))
        }
        var firstTaken = costs.size / 2
        var secondTaken = costs.size / 2
        var answer = 0
        list.sortByDescending { it.third }
        for (i in 0 until list.size) {
            if ((list[i].first > list[i].second && secondTaken > 0) || firstTaken == 0) {
                answer += list[i].second
                secondTaken--
            } else {
                answer += list[i].first
                firstTaken--
            }
        }
        return answer
    }
}

fun main() {
    val s = TwoCityScheduling()
    s.twoCitySchedCost(
        arrayOf(
            intArrayOf(259, 770),
            intArrayOf(448, 54),
            intArrayOf(926, 667),
            intArrayOf(184, 139),
            intArrayOf(840, 118),
            intArrayOf(577, 469)
        )
    )
}