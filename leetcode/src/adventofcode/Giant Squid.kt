package adventofcode

val tableWon = BooleanArray(9000)
val wonCols = Array(900) { BooleanArray(5) }
fun GiantSquid(numbers: List<Int>, matrices: MutableList<Array<IntArray>>): Int {
    val visited = Array(matrices.size) { Array(matrices[0].size) { BooleanArray(matrices[0][0].size) } }

    var currentWinner = 0
    numbers.forEach { number ->
        matrices.forEachIndexed { index, it ->
            if (isWinner(number, index, matrices, visited)) {
                if (!tableWon[index]) {
                    currentWinner = getSumOfUnMarked(index, visited, matrices) * number
                    tableWon[index] = true
                }
            }
        }
    }
    return currentWinner
}

fun getSumOfUnMarked(index: Int, visited: Array<Array<BooleanArray>>, matrices: MutableList<Array<IntArray>>): Int {
    var answer = 0
    visited[index].forEachIndexed { row, it ->
        it.forEachIndexed { col, element ->
            if (!element) {
                answer += matrices[index][row][col]
            }
        }
    }
    return answer
}

fun isWinner(
    number: Int,
    index: Int,
    matrices: MutableList<Array<IntArray>>,
    visited: Array<Array<BooleanArray>>
): Boolean {
    matrices[index].forEachIndexed { row, it ->
        it.forEachIndexed { col, element ->
            if (element == number) {
                visited[index][row][col] = true
                if (checkIfWinner(index, row, col, visited)) return true
            }
        }

    }
    return false
}

fun checkIfWinner(index: Int, row: Int, col: Int, visited: Array<Array<BooleanArray>>): Boolean {
    var answer = true
    visited[index][row].forEach {
        answer = answer.and(it)
    }
    if (answer) {
        return true
    }
    answer = true
    visited[index].forEach {
        answer = answer.and(it[col])
    }
    if (answer) {
        wonCols[index][col] = true
        return answer
    }
    return answer
}

fun main() {
    var line: String? = readLine()
    val numbers = mutableListOf<Int>()
    line?.split(",")?.forEach {
        numbers.add(it.toInt())
    }
    readLine()
    line = readLine()
    val list = mutableListOf<Array<IntArray>>()
    while (line != null && line.isNotEmpty()) {
        val newMatrix = Array(5) { IntArray(5) }
        for (row in 0 until 5) {
            if (line.isNullOrEmpty()) break
            var index = 0
            line?.split(" ")?.forEach { it -> if (it.isNotEmpty()) newMatrix[row][index++] = it.toInt() }
            line = readLine()
        }
        //if(line.isNullOrEmpty()) break
        list.add(newMatrix)
        line = readLine()
    }
    println(GiantSquid(numbers, list))
}