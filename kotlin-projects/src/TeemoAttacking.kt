import java.util.*

class TeemoAttacking {
    fun findPoisonedDuration(timeSeries: IntArray, duration: Int): Int {
        val time = IntArray(20_000_002)
        timeSeries.forEach {
            time[it + duration] -= 1
            time[it] += 1
        }
        var ans =  if (time[0] > 0) 1 else 0
        for (timePoint in 1 until time.size) {
            time[timePoint] += time[timePoint - 1]
            ans += if (time[timePoint] > 0) 1 else 0
        }
        return ans
    }


}

fun main() {
    val s = TeemoAttacking()
    println(Date().time)
    println(s.findPoisonedDuration(intArrayOf(0,4), 2))
    println(Date().time)
}