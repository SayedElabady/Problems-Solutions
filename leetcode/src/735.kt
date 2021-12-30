import kotlin.math.abs

class Solution735 {
    fun asteroidCollision(asteroids: IntArray): IntArray {
        val negativeValues = mutableListOf<Int>()
        val positiveValues = mutableListOf<Int>()
        asteroids.forEach{
            if(it < 0) negativeValues.add(it)
            else positiveValues.add(it)
        }
        if(positiveValues.size == 0 || negativeValues.size == 0) return asteroids
        var positiveIndex = positiveValues.size - 1
        var negativeIndex = negativeValues.size - 1
        while(positiveIndex !=0 &&negativeIndex!=0){
            if(positiveValues[positiveIndex] > abs(negativeValues[negativeIndex])){
                negativeIndex--
            }else if(positiveValues[positiveIndex] < abs(negativeValues[negativeIndex])){
                positiveIndex--
            }else{
                negativeIndex--
                positiveIndex--
            }
        }
        return if(positiveIndex == 0 && negativeIndex == 0){
            intArrayOf()
        }else if(negativeIndex == 0){
            positiveValues.subList(0,positiveIndex+1).toIntArray()
        }else{
            negativeValues.subList(0,negativeIndex+1).toIntArray()
        }
    }
}

fun main() {
    val s = Solution735()
    s.asteroidCollision(intArrayOf(10,2,-5))
}