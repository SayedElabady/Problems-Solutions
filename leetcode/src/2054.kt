import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.math.max

class Solution2054 {
//    fun maxTwoEvents(events: Array<IntArray>): Int {
//////        events.sortBy { it[0] }
//////        val test = PriorityQueue<IntArray>(compareBy { it[1] })
//////
//////
//////        var iterator = events.size
//////        var currentMax = 0
//////        var answer = 0
//////        val maxValuesMap = HashMap<Int, Int>()
//////        while (iterator >= 0) {
//////            val maxValueToAdd = maxValuesMap(events[iterator][1])
//////            currentMax = max(currentMax, events[iterator][2])
//////            maxValuesMap[events[iterator][0]] = currentMax
//////            answer = if (maxValueToAdd == -1) {
//////                max(answer, currentMax)
//////            } else {
//////                max(answer, currentMax + maxValueToAdd)
//////            }
//////        }
//////        return answer
//////    }
//////
//////    fun HashMap<Int, Int>.binarySearch(value: Int): Int {
//////        var left = 0
//////        var right = this.size
//////        while (left < right) {
//////            val mid =
//////        }
//////    }

    fun rotatedDigits(n: Int): Int {
        val validNumbers = intArrayOf(0, 1, 5, -1, -1, 2, 9, -1, 8, 6)
        var answer = 0
        (1..n).forEach{
            if(checkIfGoodNumber(it, validNumbers) == true) answer++
        }
        return answer
    }

    fun checkIfGoodNumber(number: Int, validNumbers: IntArray): Boolean{
        //if(number == 10) return false
        var numberToCheck = number
        var newNumber = 0
        var multiplier = 1
        while(numberToCheck != 0){
            val modulus = numberToCheck % 10
            if(validNumbers[modulus]== -1)return false
            if(multiplier == 1 && validNumbers[modulus] ==0)
                newNumber = 1
            else
            newNumber = newNumber * multiplier + validNumbers[modulus]
            multiplier*=10
            numberToCheck /= 10
        }
        return newNumber != number
    }

}

fun main() {
    val s = Solution2054()
    s.rotatedDigits(10)
}