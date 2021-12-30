package codility


data class Coordinates(val x: Int, val y: Int)

fun solution(R: Array<String>): Int {
    val visited = Array(21) { IntArray(21) }
    if (R[0].length == 1) return if (R[0][0] == '.') 1 else 0
    traverse(R, visited, 'r', Coordinates(0, 0))

    var answer = 0
    visited.forEach { row ->
        row.forEach {
            if (it > 0) answer++
        }
    }
    return answer
}

// This function needs refactoring, but I need more time for this.
fun traverse(grid: Array<String>, visited: Array<IntArray>, direction: Char, coordinates: Coordinates) {
    if (visited[coordinates.x][coordinates.y] > 1) return
    visited[coordinates.x][coordinates.y]++

    var newCoordinates = getNewCoordinates(direction, coordinates)
    if (areCoordinatesValid(grid, newCoordinates)) {
        traverse(grid, visited, direction, newCoordinates)
    } else {
        var newDirection = getNewDirection(direction)
        newCoordinates = getNewCoordinates(newDirection, coordinates)
        if (areCoordinatesValid(grid, newCoordinates)) {
            traverse(grid, visited, newDirection, newCoordinates)
        } else {
            newDirection = getNewDirection(newDirection)
            newCoordinates = getNewCoordinates(newDirection, newCoordinates)
            if (areCoordinatesValid(grid, newCoordinates)) {
                traverse(grid, visited, newDirection, newCoordinates)
            } else {
                newDirection = getNewDirection(newDirection)
                newCoordinates = getNewCoordinates(newDirection, newCoordinates)
                if (areCoordinatesValid(grid, newCoordinates)) {
                    traverse(grid, visited, newDirection, newCoordinates)
                }
            }
        }

    }

}

fun areCoordinatesValid(grid: Array<String>, coordinates: Coordinates): Boolean {
    if (coordinates.x >= grid.size || coordinates.y >= grid[0].length || coordinates.y < 0 || coordinates.x < 0 || grid[coordinates.x][coordinates.y] == 'X') return false
    return true
}

fun getNewDirection(direction: Char): Char {
    return when (direction) {
        'r' -> 'd'
        'd' -> 'l'
        'l' -> 'u'
        else -> 'r'
    }
}

fun getNewCoordinates(direction: Char, coordinates: Coordinates): Coordinates {
    return when (direction) {
        'r' -> Coordinates(coordinates.x, coordinates.y + 1)
        'l' -> Coordinates(coordinates.x, coordinates.y - 1)
        'u' -> Coordinates(coordinates.x - 1, coordinates.y)
        else -> Coordinates(coordinates.x + 1, coordinates.y)
    }
}


fun main() {
    solution(arrayOf("....X..", "X......", ".....X.", "......."))

}