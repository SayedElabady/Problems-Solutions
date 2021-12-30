class Solution130 {
    val visited = Array(201){BooleanArray(201)}
    val directions = arrayOf(intArrayOf(-1,0),intArrayOf(0,1),intArrayOf(1,0),intArrayOf(0,-1))

    fun solve(board: Array<CharArray>): Unit {
        val pointsToChange = mutableListOf<Point>()
        board.forEachIndexed{x,  row ->
            row.forEachIndexed{y, element ->
                if(element == 'O' && !visited[x][y]){
                    val list = mutableListOf<Point>()
                    traverse(board, Point(x,y), list)
                    if(shouldBeAdded(list, board))
                        pointsToChange.addAll(list)
                }

            }

        }
        pointsToChange.forEach{
            board[it.x][it.y]= 'X'
        }

    }
    fun shouldBeAdded(points: List<Point>, board: Array<CharArray>) :Boolean{
        points.forEach{
            if(it.x== 0 || it.x==board.size-1 || it.y==0 || it.y == board[0].size-1)
                return false
        }
        return true
    }

    fun traverse(board: Array<CharArray>, point: Point, traversed: MutableList<Point>): List<Point>{
        visited[point.x][point.y]=true
        traversed.add(point)
        directions.forEach{
            if(isPointValid(Point(point.x + it[0], point.y + it[1]), board))
                traverse(board, Point(point.x + it[0], point.y + it[1]) , traversed)
        }
        return traversed
    }

    fun isPointValid(point: Point, board: Array<CharArray>): Boolean{
        return point.x < board.size && point.x>=0 && point.y >=0 && point.y < board[0].size && !visited[point.x][point.y]
                && board[point.x][point.y] == 'O'
    }


    data class Point(val x: Int, val y: Int)
}

fun main() {
    val s = Solution130()
    s.solve(arrayOf(charArrayOf('X', 'X', 'X', 'X'), charArrayOf('X', 'O', 'O', 'X'), charArrayOf('X', 'X', 'O', 'X'), charArrayOf('X', 'O', 'X', 'X')))
}