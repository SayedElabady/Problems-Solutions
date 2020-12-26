class Solution547 {
    val visited = BooleanArray(201)
    fun findCircleNum(M: Array<IntArray>): Int {
        var result = 0
        for (friend in 0 until M.size) {
            if (!visited[friend]) {
                markVisited(friend, M)
                result++
            }
        }
        return result
    }

    fun markVisited(node: Int, M: Array<IntArray>) {
        visited[node] = true
        for (nodeFriends in 0 until M[node].size) {
            if (M[node][nodeFriends] == 1 && !visited[nodeFriends])
                markVisited(nodeFriends, M)
        }
    }

}

fun main() {
    val s = Solution547()
    print(
        s.findCircleNum(
            arrayOf(
                intArrayOf(1, 1, 0),
                intArrayOf(1, 1, 1),
                intArrayOf(0, 1, 1)
            )
        )
    )
}