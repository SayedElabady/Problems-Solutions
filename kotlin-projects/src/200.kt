import kotlin.math.max

fun main(){
    val sol = Solution10()
//    print(sol.numIslands(Array(4){
//        when (it) {
//            0 -> charArrayOf('1' , '1' ,'0' ,'0' ,'0')
//            1 -> charArrayOf('1' , '1' ,'0' ,'0' ,'0')
//            2 -> charArrayOf('0' , '0' ,'1' ,'0' ,'0')
//            else -> charArrayOf('0' , '0' ,'0' ,'1' ,'1')
//        }
//    }))
    print(sol.numIslands(Array(0){ CharArray(0)}))

}
class Solution10 {

    fun numIslands(grid: Array<CharArray>): Int {
        val maxX = grid.size
        val maxY = grid.firstOrNull()?.size ?: return 0
        val visited = Array(maxX) { BooleanArray(maxY) { false } }
        var sum = 0
        for (x in 0 until maxX) {
            for (y in 0 until maxY)
                if (grid[x][y] == '1' && !visited[x][y]) {
                    sum++
                    visit(grid, x, y, maxX, maxY, visited)
                }
        }
        return sum
    }

    fun visit(grid: Array<CharArray>, x: Int, y: Int, maxX: Int, maxY: Int, visited: Array<BooleanArray>) {
        if (x >= maxX || y >= maxY ) return
        visited[x][y] = true
        if (x - 1 >= 0 && grid[x - 1][y] == '1' && !visited[x - 1][y]) visit(grid, x - 1, y, maxX, maxY, visited)
        if (x + 1 < maxX && grid[x + 1][y] == '1' && !visited[x + 1][y]) visit(grid, x + 1, y, maxX, maxY, visited)
        if (y - 1 >= 0 && grid[x][y - 1] == '1' && !visited[x][y - 1]) visit(grid, x, y - 1, maxX, maxY, visited)
        if (y + 1 < maxY && grid[x][y + 1] == '1' && !visited[x][y + 1]) visit(grid, x, y + 1, maxX, maxY, visited)
    }


}