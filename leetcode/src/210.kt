import java.util.*

class Solution210 {
    fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
        val indegrees = IntArray(numCourses)
        val adj = Array(numCourses){mutableListOf<Int>()}
        prerequisites.forEach{
            adj[it[1]].add(it[0])
            if(adj[it[0]].contains(it[1])) return intArrayOf()
            indegrees[it[0]]++
        }
        val answer = IntArray(numCourses)
        var index = 0
        val queue = ArrayDeque<Int>()
        indegrees.forEachIndexed{index1, it ->
            if(it == 0) queue.addFirst(index1)
        }
        
        val visited = BooleanArray(numCourses)
        while(queue.isNotEmpty()){
            val toBeProccessed = queue.removeLast()
            if(visited[toBeProccessed]) return intArrayOf()
            visited[toBeProccessed] = true
            answer[index++]=toBeProccessed
            adj[toBeProccessed].forEach{
                indegrees[it]--
                if(indegrees[it] == 0){
                    queue.addFirst(it)
                }
            }
        }
        return answer

    }
}



fun main() {
    val s = Solution210()
   // s.findOrder(4, arrayOf(intArrayOf(1,0),intArrayOf(2,0),intArrayOf(3,1),intArrayOf(3,2)))
    s.findOrder(3, arrayOf(intArrayOf(1,0),intArrayOf(0,2),intArrayOf(2,1)))

}