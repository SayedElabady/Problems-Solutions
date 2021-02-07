class Solution539 {
    fun findMinDifference(timePoints: List<String>): Int {
        val hoursSlots = mutableListOf<Int>()
        for (index in timePoints.size-1 downTo 0) {
            val splitedTime = timePoints[index].split(":")
            hoursSlots.add((Integer.valueOf(splitedTime[0]) * 60) + Integer.valueOf(splitedTime[1]))
        }
        hoursSlots.sort()
        var answer = Int.MAX_VALUE
        for (hour in 1 until hoursSlots.size) {
            answer = Math.min(answer, hoursSlots[hour] - hoursSlots[hour - 1])
        }
        return Math.min(answer, 1440 - hoursSlots.last() + hoursSlots.first())
    }
}

fun main() {
    val s = Solution539()
    s.findMinDifference(listOf("23:59","00:00"))
}