class BiWeekly66A{
    fun countWords(words1: Array<String>, words2: Array<String>): Int {
        val map = HashMap<String, Int>()
        val map1 = HashMap<String, Int>()

        words1.forEach {
            map[it] = map.getOrDefault(it, 0) + 1
        }
        words2.forEach {
            map1[it] = map.getOrDefault(it, 0) + 1
        }
        var answer = 0
        map.forEach{
            if(it.value == 1 && map1[it.key] == 1) answer++
        }
        return answer
    }

}

fun main() {
    val s = BiWeekly66A()
    s.countWords(arrayOf("leetcode","is","amazing","as","is"), arrayOf("amazing","leetcode","is"))
}