class MagicDictionary() {
    val dictionary = mutableListOf<String>()

    fun buildDict(dictionary: Array<String>) {
        dictionary.forEach {
            this.dictionary.add(it)
        }
    }

    fun search(searchWord: String): Boolean {
        var diff: Int
        dictionary.filter { it.length == searchWord.length }.forEach { word ->
            diff = 0
            searchWord.forEachIndexed { index, char ->
                if (char != word[index])
                    diff++
            }
            if (diff == 1) return true
        }
        return false
    }

    fun getCharCountOfWord(word: String): IntArray {
        val charCount = IntArray(27)
        word.forEach { char ->
            charCount[char - 'a']++
        }
        return charCount
    }

}

fun main() {
    val dict = MagicDictionary()
    dict.buildDict(arrayOf("abc", "leetcode"))
    dict.search("cba")
}