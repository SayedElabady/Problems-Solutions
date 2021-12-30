import kotlin.math.min

class ASSESS2{
    fun maxDistToClosest(seats: IntArray): Int {
        val nearestFromRight = IntArray(seats.size){Int.MAX_VALUE}
        val nearestFromLeft = IntArray(seats.size){Int.MAX_VALUE}

        val firstOccupiedSeat = seats.indexOfFirst{it == 1}
        var lastOccSeat = firstOccupiedSeat
        (firstOccupiedSeat until seats.size).forEach{ it->
            if(seats[it] == 1) lastOccSeat =it
            nearestFromRight[it] = lastOccSeat
        }

        val lastOccupiedSeat = seats.indexOfLast{it == 1}
        lastOccSeat = lastOccupiedSeat
        (lastOccupiedSeat downTo 0).forEach{ it->
            if(seats[it] == 1) lastOccSeat = it
            nearestFromLeft[it] = lastOccSeat
        }
        var answer = 0
        var minTillNow = Int.MIN_VALUE
        seats.forEachIndexed{index, it->
            if(it != 1){
                var localMin = Int.MAX_VALUE
                if(nearestFromLeft[index] != Int.MAX_VALUE){
                    localMin = min(nearestFromLeft[index] - index, localMin)
                }
                if(nearestFromRight[index] != Int.MAX_VALUE){
                    localMin = min(index - nearestFromRight[index], localMin)
                }
                if(localMin> minTillNow){
                    minTillNow = localMin
                    answer = minTillNow
                }
            }
        }
        return answer
    }
}

fun main() {
    val s = ASSESS2()
        s.maxDistToClosest(intArrayOf(0,0,1))
}
