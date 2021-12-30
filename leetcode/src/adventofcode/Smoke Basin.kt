package adventofcode

import kotlin.math.abs

class SmokeBasin {
    val directions = arrayOf(intArrayOf(1, 0), intArrayOf(-1, 0), intArrayOf(0, 1), intArrayOf(0, -1))
    fun smokeBasin(input: List<List<Int>>): Int {
        var answer = mutableListOf<Int>()
        val visited = Array(input.size){BooleanArray(input[0].size)}
        for (row in 0 until input.size) {
            for (col in 0 until input[0].size) {
                var isValid = true
                if(visited[row][col]) continue
                directions.forEach {
                    if(isValid(input, row+it[0], col+it[1]) && input[row+it[0]][col+it[1]] <= input[row][col])
                        isValid = false
                }
                if(isValid) answer.add(dfs(input, row, col, visited))
            }
        }
        answer.sort()
        val lst = answer.size-1
        return answer[lst] * answer[lst-1] * answer[lst-2]
    }

    fun isValid(input: List<List<Int>>, row: Int, col: Int): Boolean {
        return (row >= 0 && row < input.size && col >= 0 && col < input[0].size)
    }

    fun dfs(input: List<List<Int>>, row: Int, col:Int, visited: Array<BooleanArray>): Int{
        if(visited[row][col]) return 0
        //println("$row    $col")
        var count = 1
        visited[row][col] = true
        directions.forEach {
            if(isValid(input, row+it[0], col+it[1]) &&input[row+it[0]][col+it[1]] > input[row][col] && input[row+it[0]][col+it[1]] != 9){
               count += dfs(input, row + it[0], col+it[1], visited)
            }

        }
        return count
    }
}

fun main() {
    var line: String? = readLine()
    val list = mutableListOf<List<Int>>()
    while (line != null && line.isNotEmpty()) {
        list.add(line.map { it.toString().toInt() })
        line = readLine()
    }
    val s = SmokeBasin()
    println(s.smokeBasin(list))
}
