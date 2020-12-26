class Solution784 {
    val set = mutableSetOf<String>()
    val visited = mutableMapOf<Pair<String,Int>, Boolean>()

    fun letterCasePermutation(S: String): List<String> {
        mutate(0, S)
        return set.toList()
    }

    fun mutate(index: Int, string: String) {
        set.add(string)
        if (visited[Pair(string,index)] == true || index >= string.length)
            return
        visited[Pair(string,index)] = true
        mutate(index + 1, string.substring(0, index) + string[index].toLowerCase() + string.substring(index + 1))

        mutate(index + 1, string.substring(0, index) + string[index].toUpperCase() + string.substring(index + 1))
    }

}

fun main() {
    val s = Solution784()
    print(s.letterCasePermutation("a1b2"))
}