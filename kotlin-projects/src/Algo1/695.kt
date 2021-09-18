package Algo1

class Solution695 {
    val visited = Array(55) { BooleanArray(55) }

    fun maxAreaOfIsland(grid: Array<IntArray>): Int {
        var max = -1
        grid.forEachIndexed { x, array ->
            array.forEachIndexed { y, it ->
                if (it == 1 && !visited[x][y])
                    max = kotlin.math.max(max, check(grid, x, y))
            }
        }
        return max
    }

    fun check(image: Array<IntArray>, x: Int, y: Int): Int {
        if (visited[x][y]) return 0
        visited[x][y] = true
        var count = 1
        if (x + 1 < image.size && image[x + 1][y] == 1) {
            count += check(image, x + 1, y)
        }
        if (y + 1 < image[0].size && image[x][y + 1] == 1) {
            count += check(image, x, y + 1)
        }
        if (x - 1 >= 0 && image[x - 1][y] == 1) {
            count += check(image, x - 1, y)
        }
        if (y - 1 >= 0 && image[x][y - 1] == 1) {
            count += check(image, x, y - 1)
        }
        return count
    }
}