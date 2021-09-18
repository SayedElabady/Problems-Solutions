package Algo1

class Solution733 {

    val visited = Array<BooleanArray>(55) { BooleanArray(55) }
    fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, newColor: Int): Array<IntArray> {
        check(image,sr,sc,newColor)
        return image
    }

    fun check(image: Array<IntArray>, x: Int, y: Int, target: Int) {
        if(visited[x][y])return
        visited[x][y] = true

        if (x + 1 < image.size && image[x + 1][y] == image[x][y]) {
            check(image, x + 1, y, target)
        }
        if (y + 1 < image[0].size && image[x][y + 1] == image[x][y]) {
            check(image, x, y + 1, target)
        }
        if (x - 1 >=0 &&  image[x - 1][y] == image[x][y]) {
            check(image, x - 1, y, target)
        }
        if (y - 1 >=0 && image[x][y - 1] == image[x][y]) {
            check(image, x, y - 1, target)
        }
        image[x][y] = target
    }
}