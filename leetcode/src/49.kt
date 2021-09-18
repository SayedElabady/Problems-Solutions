class Solution49 {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val listsMap = HashMap<String, MutableList<String>>()
        strs.forEach {
            val sortedString = it.toCharArray().sorted().joinToString("")
            if (listsMap[sortedString] != null)
                listsMap[sortedString]?.add(it) else
                listsMap[sortedString] = mutableListOf(it)
        }
        val answer = mutableListOf<List<String>>()
            answer.addAll(listsMap.values)
        return answer.toList()
    }
}

fun main() {
    val s = Solution49()
    s.groupAnagrams(arrayOf(""))
}