package adventofcode

import kotlin.math.max
import kotlin.math.min

data class Point(val x: Int, val y: Int)

fun hydrothermalVenture(list: MutableList<Pair<Point, Point>>): Int {
    val map = Array(1000) { IntArray(1000) }
   for(iterator in 0 until list.size) {
       val it = list[iterator]
        if (it.first.x == it.second.x) {
            for (index in minOf(it.first.y, it.second.y)..maxOf(it.first.y, it.second.y)) {
                    map[index][it.first.x]++
            }
        } else if(it.first.y == it.second.y) {
            for (index in minOf(it.first.x, it.second.x)..maxOf(it.first.x, it.second.x)) {
                map[it.first.y][index]++
            }
        }else{
            if(it.first.x >= it.second.x){
                var col = it.second.y
                for (index in it.second.x..it.first.x){
                    map[col][index]++
                    if(it.first.y > it.second.y) col++
                    else col--
                }
            }else{
                var col = it.first.y
                for (index in it.first.x..it.second.x){
                    map[col][index]++
                    if(it.first.y > it.second.y) col--
                    else col++
                }
            }
            val minRow = minOf(it.first.x, it.second.x)
            val maxRow = maxOf(it.first.x, it.second.x)
            var minCol = minOf(it.first.y, it.second.y)
//            for (index in minRow..maxRow){
//                map[minCol++][index]++
//            }
        }
    }

    var answer = 0
    map.forEach {
        it.forEach {
            if (it > 1) answer++
        }
    }
    return answer
}

fun main() {
    var line: String? = readLine()
    val list = mutableListOf<Pair<Point, Point>>()
    while (line != null && line.isNotEmpty()) {
        val splitString = line.split(" -> ")
        val firstPointString = splitString[0].split(",")
        val secondPointString = splitString[1].split(",")
        val firstPoint = Point(firstPointString[0].toInt(), firstPointString[1].toInt())
        val secondPoint = Point(secondPointString[0].toInt(), secondPointString[1].toInt())
        list.add(firstPoint to secondPoint)
        line = readLine()
    }
    println(hydrothermalVenture(list))
}