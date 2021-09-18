class Solution216 {
    val answer = MutableList<List<Int>>(0) { listOf() }
    fun combinationSum3(k: Int, n: Int): List<List<Int>> {
        traverse(k, 1, n, mutableListOf())
        return answer
    }

    fun traverse(target: Int, level: Int, remaining: Int, currentNumbers: MutableList<Int>) {
        if (remaining == 0 && currentNumbers.size == target) {
            answer.add(currentNumbers)
            return
        }
        if (level > 9 || remaining < 0) return
        traverse(target, level + 1, remaining, currentNumbers)
        traverse(target, level + 1, remaining - level, currentNumbers.copy().apply {
            add(level)
        })

    }

    fun MutableList<Int>.copy(): MutableList<Int> {
        val newList = mutableListOf<Int>()
        this.forEach {
            newList.add(it)
        }
        return newList
    }

}

fun main() {
    val s = Solution216()
    s.combinationSum3(9, 45)
}

