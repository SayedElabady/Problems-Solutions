class Solution289 {
    val coordinates =
        arrayOf(Pair(0, 1), Pair(0, -1), Pair(1, -1), Pair(-1, -1), Pair(1, 1), Pair(-1, 1), Pair(1, 0), Pair(-1, 0))

    fun gameOfLife(board: Array<IntArray>): Unit {
        val original = Array<IntArray>(board.size){ intArrayOf(board[0].size)}
        board.forEachIndexed { index, array -> original[index] = array.copyOf() }
        for (x in 0 until original.size) {
            for (y in 0 until original[0].size) {
                val count = countManyLiveNeighbours(x, y, original)
                if (original[x][y] == 0) {
                    if (count == 3) board[x][y] = 1
                } else {
                    if (count < 2 || count > 3) board[x][y] = 0
                }
            }
        }

    }

    fun countManyLiveNeighbours(x: Int, y: Int, board: Array<IntArray>): Int {
        var count = 0
        coordinates.forEach {
            if (isValid(board, x + it.first, y + it.second) && board[x + it.first][y + it.second] == 1) count++
        }
        return count
    }

    fun isValid(board: Array<IntArray>, x: Int, y: Int): Boolean {
        return x >= 0 && x < board.size && y >= 0 && y < board[0].size
    }
}

fun main() {
    val s = Solution289()
    s.gameOfLife(arrayOf(intArrayOf(0, 1, 0), intArrayOf(0,0,1), intArrayOf(1,1,1), intArrayOf(0,0,0)))
}