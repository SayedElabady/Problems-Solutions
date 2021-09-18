import java.lang.NumberFormatException
import java.util.Arrays
import java.util.stream.IntStream


class Solution36 {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        (0..2).forEach { iterator ->
            val column = board.mapIndexed { index, chars -> chars[iterator] }.toCharArray()
            if (!(checkLine(board[iterator]) && checkLine(column))) return false
        }
        (0..2).forEach { outer ->
            (0..2).forEach { inner ->
                if (!checkSquare(board,outer * 3, inner * 3)) return false
            }
        }
        return true
    }

    fun checkSquare(board: Array<CharArray>, outer: Int, inner: Int): Boolean {
        val found = BooleanArray(10)
        for(x in outer..outer+2){
            for (y in inner..inner+3){
                try {
                    val num = board[x][y].toString().toInt()
                    if (found[num])
                        return false
                    found[num] = true
                } catch (e: NumberFormatException) {
                }
            }
        }
        return true
    }

    fun checkLine(line: CharArray): Boolean {
        val found = BooleanArray(10)
        line.forEach {
            try {
                val num = it.toString().toInt()
                if (found[num])
                    return false
                found[num] = true
            } catch (e: NumberFormatException) {
            }
        }
        return true
    }
}

fun main() {
    val d = Solution36()
    d.isValidSudoku(arrayOf(charArrayOf('5','3','.','.','7','.','.','.','.'),
        charArrayOf('6','.','.','1','9','5','.','.','.'),
        charArrayOf('.','9','8','.','.','.','.','6','.')))
}

