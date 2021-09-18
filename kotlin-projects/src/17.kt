import CoderByte.visitedNodes

class Solution17 {
    val answer = mutableListOf<String>()
    fun letterCombinations(digits: String): List<String> {
        if(digits.isEmpty()) return emptyList()
        val groups = listOf("abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz")
        val selectedGroups = digits.mapIndexed { index, c ->
            groups[c.toString().toInt() - 2]
        }
        val visited = HashMap<String, Boolean>()
        iterate(0, selectedGroups, digits.length, "", visited)
        return answer
    }

    fun iterate(
        index: Int,
        selectedGroups: List<String>,
        limit: Int,
        string: String,
        visited: HashMap<String, Boolean>
    ) {
        if (index == limit) {
            answer.add(string)
            return
        }
        if (visited[string] == true) return
        visited[string] = true
        for (iterator in selectedGroups[index].indices) {
            iterate(index + 1, selectedGroups, limit, string + selectedGroups[index][iterator], visited)
        }
    }
}

fun main() {
    val s = Solution17()
    val ss = s.letterCombinations("23")
    print(ss[0])
}