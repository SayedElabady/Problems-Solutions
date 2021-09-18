package July

import kotlin.math.abs
import kotlin.math.min

class AngleBetweenHandsofaClock {
    fun angleClock(hour: Int, minutes: Int): Double {
        val hoursAngle = 30.0 / (60.0 / minutes.toDouble()) + (hour.toDouble() % 12) * 30
        val minsAngle = minutes.toDouble() * 6.0
        val angle = abs(hoursAngle - minsAngle)
        return min(angle, 360.0 - angle)
    }
}

fun main() {
    val a = AngleBetweenHandsofaClock()
    print(a.angleClock(1, 57))
}