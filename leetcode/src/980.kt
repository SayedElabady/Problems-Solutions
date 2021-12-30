class Solution980 {
//    var answer = 0
//    var requiredCount = 0
//    var start = Pair(0, 0)
//    fun uniquePathsIII(grid: Array<IntArray>): Int {
//        grid.forEachIndexed { x, it ->
//            it.forEachIndexed { y, element ->
//                if (element == 0) requiredCount++
//                if (element == 1) {
//                    start = Pair(x, y)
//                }
//            }
//        }
//        traverse(start.first, start.second, grid, Array(grid.size) { IntArray(grid[0].size) }, 0)
//        return answer
//    }
//
//    fun traverse(x: Int, y: Int, grid: Array<IntArray>, visited: Array<IntArray>, count: Int) {
//        if (grid[x][y] == 2) {
//            if (count - 1 == requiredCount) answer++
//            return
//        }
//        if (visited[x][y] == 1) return
//        visited[x][y] = 1
//        if (x + 1 < grid.size && grid[x + 1][y] != -1) traverse(x + 1, y, grid, visited.copy(), count + 1)
//        if (x - 1 >= 0 && grid[x - 1][y] != -1) traverse(x - 1, y, grid, visited.copy(), count + 1)
//        if (y + 1 < grid[0].size && grid[x][y + 1] != -1) traverse(x, y + 1, grid, visited.copy(), count + 1)
//        if (y - 1 >= 0 && grid[x][y - 1] != -1) traverse(x, y - 1, grid, visited.copy(), count + 1)
//
//    }
//
//    fun Array<IntArray>.copy(): Array<IntArray> {
//        val ret = Array(this.size) { IntArray(this[0].size) }
//        this.forEachIndexed { x, ints ->
//            ints.forEachIndexed { y, element ->
//                ret[x][y] = element
//            }
//        }
//        return ret
//    }
    fun uniquePathsIII(grid: Array<IntArray>): Int {
    var numberOfZeroes = 0

        var startingX = 0
        var startingY = 0
        grid.forEachIndexed{x, row->
            row.forEachIndexed{y, item ->
                if(item == 0) numberOfZeroes++
                else if(item ==1){ startingX =x
                    startingY = y
                }
            }
        }
        return traverse(grid, startingX, startingY, numberOfZeroes)
    }

    fun traverse(grid: Array<IntArray>, x: Int, y:Int, numberOfZeroes: Int) : Int{
        if(x>=grid.size||x<0 || y>=grid[0].size || y<0 || grid[x][y] == -1) return 0

        if(grid[x][y]==2) {
            return if(numberOfZeroes == 0) 1
            else 0
        }
        grid[x][y] = -1

        val numberOfPaths = traverse(grid, x+1, y, numberOfZeroes-1) +
                traverse(grid, x-1, y, numberOfZeroes-1) +
                traverse(grid, x, y+1, numberOfZeroes-1) +
                traverse(grid, x, y-1, numberOfZeroes-1)

        grid[x][y]=0

        return numberOfPaths
    }
}

fun main() {
    val s = Solution980()
    // println(s.uniquePathsIII(arrayOf(intArrayOf(1, 0, 0, 0), intArrayOf(0, 0, 0, 0), intArrayOf(0, 0, 2, -1))))

    // println(s.uniquePathsIII(arrayOf(intArrayOf(1, 0, 0, 0), intArrayOf(0, 0, 0, 0), intArrayOf(0, 0, 0, 2))))
    println(s.uniquePathsIII(arrayOf(intArrayOf(0, 1), intArrayOf(2, 0))))

}