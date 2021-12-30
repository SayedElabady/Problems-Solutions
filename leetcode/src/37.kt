class Solution37 {
    val rows = Array(9) { BooleanArray(10) }
    val cols = Array(9) { BooleanArray(10) }
    val tables = Array(9) { BooleanArray(10) }
    var answer = arrayOf<CharArray>()
    fun solveSudoku(board: Array<CharArray>): Unit {

        for (row in board.indices) {
            for (col in board[0].indices) {
                if (board[row][col].isDigit()) {
                    val number = board[row][col].toString().toInt()
                    rows[row][number] = true
                    cols[col][number] = true
                    tables[getTable(row, col)][number] = true
                }
            }
        }

        getSolution(board, 0, 0)
        for (row in board.indices) {
            for (col in board[0].indices) {
                board[row][col] = answer[row][col]
            }
        }

    }

    fun getSolution(board: Array<CharArray>, row: Int, col: Int) {
        if (row == 9) {
            val answerList = mutableListOf<CharArray>()
            board.forEach {
                answerList.add(it.copyOf())
            }

            answer = answerList.toTypedArray()
            return
        }
        if (board[row][col].isDigit()) {
            getSolution(board, getNextElement(row, col).first, getNextElement(row, col).second)
            return
        }

        tables[getTable(row, col)].forEachIndexed { index, it ->
            if (index != 0 && !it) {
                if (canPlace(row, col, index)) {
                    place(row, col, index)
                    board[row][col] = index.toString()[0]
                    getSolution(board, getNextElement(row, col).first, getNextElement(row, col).second)
                    remove(row, col, index)
                    board[row][col] = '.'
                }
            }
        }
    }

    fun getNextElement(row: Int, col: Int): Pair<Int, Int> {
        if (col + 1 == 9) {
            return row + 1 to 0
        } else
            return row to col + 1
    }

    fun canPlace(row: Int, col: Int, number: Int): Boolean =
        !rows[row][number] && !cols[col][number] && !tables[getTable(row, col)][number]

    fun place(row: Int, col: Int, number: Int) {
        rows[row][number] = true
        cols[col][number] = true
        tables[getTable(row, col)][number] = true
    }

    fun remove(row: Int, col: Int, number: Int) {
        rows[row][number] = false
        cols[col][number] = false
        tables[getTable(row, col)][number] = false
    }

    fun getTable(row: Int, col: Int): Int {
        val section = (row / 3) * 3
        return section + (col / 3)
    }
}

fun main() {
    val s = Solution37()
    s.solveSudoku(
        arrayOf(
            charArrayOf('5', '3', '.', '.', '7', '.', '.', '.', '.'),
            charArrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.'),
            charArrayOf('.', '9', '8', '.', '.', '.', '.', '6', '.'),
            charArrayOf('8', '.', '.', '.', '6', '.', '.', '.', '3'),
            charArrayOf('4', '.', '.', '8', '.', '3', '.', '.', '1'),
            charArrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6'),
            charArrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.'),
            charArrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5'),
            charArrayOf('.', '.', '.', '.', '8', '.', '.', '7', '9')
        )
    )

}