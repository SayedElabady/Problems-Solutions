import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.abs

class Solution853{

        fun carFleet(target: Int, position: IntArray, speed: IntArray): Int {
            val map = ArrayList<Pair<Double, Double>>()
            for(index in 0 until position.size){
                map.add(target.toDouble()-position[index].toDouble() to speed[index].toDouble())
            }
            map.sortBy { it.first }
            var minTime = -1.0
            var answer= 0
            map.forEach{
                var current = it.first to it.second
                val newTime = it.first/it.second
                if(newTime> minTime){
                    answer++
                    minTime = newTime
                }
            }
            return answer
        }
}

fun main() {
    val s = Solution853()
    s.carFleet(12, intArrayOf(10,8,0,5,3), intArrayOf(2,4,1,1,3))
}