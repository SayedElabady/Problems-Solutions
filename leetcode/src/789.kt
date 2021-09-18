    import kotlin.math.abs
    import kotlin.math.min

class Solution789 {


    fun escapeGhosts(ghosts: Array<IntArray>, target: IntArray): Boolean {

        val myPath = findMinDistance(Pair(0, 0), Pair(target[0], target[1]))
        ghosts.forEach {
            val ghostPath = findMinDistance(Pair(it[0], it[1]), Pair(target[0], target[1]))
            if (ghostPath < myPath) return false
        }
        return true
    }

    fun findMinDistance(node: Pair<Int, Int>, target: Pair<Int, Int>): Int {
       return abs(node.first - target.first) + abs(node.second - target.second)
    }

}

fun main() {
    val s = Solution789()
    print(s.escapeGhosts(arrayOf(intArrayOf(1, 3), (intArrayOf(1, 0))), intArrayOf(0, 1)))
}