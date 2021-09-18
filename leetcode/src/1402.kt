class Solution1402 {
    var max = Int.MIN_VALUE
    fun maxSatisfaction(satisfaction: IntArray): Int {
        max = Int.MIN_VALUE
        val visited = HashMap<Pair<Int, Int>, Boolean>()
        satisfaction.sort()
        traverse(satisfaction, 0, 1, 0, visited)
        return max
    }

    fun traverse(
        satisfaction: IntArray,
        index: Int,
        multiplier: Int,
        sum: Int,
        visited: HashMap<Pair<Int, Int>, Boolean>
    ) {
        if (index == satisfaction.size) {
            max = Math.max(sum, max)
            return
        }
        if (visited[Pair(index, multiplier)] == true) return
        visited[Pair(index, multiplier)] = true
        traverse(satisfaction, index + 1, multiplier, sum, visited)
        traverse(satisfaction, index + 1, multiplier + 1, sum + (satisfaction[index] * multiplier), visited)
    }

    fun shouldBeRemoved(satisfaction: IntArray, index: Int, multiplier: Int): Boolean {
        var currentMultiplier = multiplier
        var sumIfRemoved = 0
        var sumIfNotRemoved = satisfaction[index] * multiplier
        currentMultiplier++
        for (currentIndex in index + 1 until satisfaction.size) {
            sumIfRemoved += satisfaction[currentIndex] * currentMultiplier - 1
            sumIfNotRemoved += satisfaction[currentIndex] * currentMultiplier
            currentMultiplier++
        }
        return sumIfRemoved > sumIfNotRemoved
    }
}

fun main() {
    val s = Solution1402()
    println(s.maxSatisfaction(intArrayOf(-1, -8, 0, 5, -9)))
    println(s.maxSatisfaction(intArrayOf(4, 3, 2)))
    println(s.maxSatisfaction(intArrayOf(-1, -4, -5)))
    print(s.maxSatisfaction(intArrayOf(-2, 5, -1, 0, 3, -3)))


}