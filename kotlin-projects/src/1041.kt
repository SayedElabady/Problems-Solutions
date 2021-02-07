class Solution1041 {
    fun isRobotBounded(instructions: String): Boolean {
        var currentPoint = Pair(0, 0)
        val xMovement = intArrayOf(0, -1, 0, 1)
        val yMovement = intArrayOf(-1, 0, 1, 0)
        var currentPosition = 2

        (instructions).forEach {
            when (it) {
                'G' -> currentPoint = Pair(
                    currentPoint.first + xMovement[currentPosition],
                    currentPoint.second + yMovement[currentPosition]
                )
                'L' -> currentPosition--
                'R' -> currentPosition = (currentPosition+1)%4
            }
            if (currentPosition == -1) currentPosition = 3
        }
        return currentPoint.first == 0&& currentPoint.second == 0 || currentPosition != 2
    }
}

fun main() {
    val s = Solution1041()
    println(s.isRobotBounded("GGLLGG"))
    println(s.isRobotBounded("GG"))
    println(s.isRobotBounded("GL"))


}