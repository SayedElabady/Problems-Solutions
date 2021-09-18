class Solution39 {
    val solution = mutableSetOf<List<Int>>()
    val visited = hashMapOf<MutableList<Int>, Boolean>()
    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        search(0, target, candidates.sorted().toIntArray(), 0, mutableListOf())
        return solution.toList()
    }
    fun MutableList<Int>.copy(): MutableList<Int>{
        val ret = mutableListOf<Int>()
        ret.addAll(this)
        return ret
    }
    fun search(index: Int, target: Int, candidates: IntArray, sum: Int, collection: MutableList<Int>) {

        if (sum + candidates[index] == target) {
            collection.add(candidates[index])
            solution.add(collection)
            return
        } else if (sum + candidates[index] > target ) {
            return
        }
        visited[collection] = true
        search(index, target, candidates, sum + candidates[index], collection.copy().apply {
            add(candidates[index])
        })
        if (index + 1 < candidates.size) {
            search(index + 1, target, candidates, sum + candidates[index], collection.copy().apply {
                add(candidates[index])
            })
            search(index + 1, target, candidates, sum, collection)
        }
    }
}

fun main() {
    val s = Solution39()
    s.combinationSum(intArrayOf(2, 3, 6, 7), 7).forEach {
        it.forEach { println(it) }
        println()
    }
  
    val acc1 = intArrayOf(10, 64, 65, 67, 70, 74)

    val acc = intArrayOf(4, 7, 9, 10, 60, 61, 63, 66, 70)

}