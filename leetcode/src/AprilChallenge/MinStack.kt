package AprilChallenge

import kotlin.math.min
open class a{}
class b : a(){

}

fun main() {
    val A :a = b()
    val B: b = b()
}
class MinStack {
    val values = mutableListOf<Int>()
    var currentMin: Int = Int.MAX_VALUE
    val minValues = mutableSetOf<Int>()
    fun push(x: Int) {
        currentMin = kotlin.math.min(currentMin, x)
        values.add(x)
        minValues.add(x)
    }

    fun pop() {
        minValues.remove(values[values.lastIndex])
        values.removeAt(values.lastIndex)
    }

    fun top(): Int {
        return values[values.lastIndex]
    }

    fun getMin(): Int {
        return minValues.first()
    }

}
