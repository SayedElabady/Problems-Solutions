class MapSum() {

    val wordsMap = HashMap<String, Int>()

    fun insert(key: String, `val`: Int) {
        wordsMap[key] = `val`
    }

    fun sum(prefix: String): Int {
        var sum = 0
        wordsMap.forEach {
            if (it.key.length > prefix.length && isPrefix(prefix, it.key)) {
                sum += it.value
            }
        }
        return sum
    }

    fun isPrefix(prefix: String, word: String): Boolean {
        for (index in prefix.indices) {
            if (prefix[index] != word[index]) return false
        }
        return true
    }

}

fun main() {

    val map = MapSum()
    map.insert("apple", 5)
    map.insert("apple", 3)
    println(map.sum("ap"))         // return 3 (apple = 3)
    map.insert("app", 2)
    println(map.sum("ap"))
}
