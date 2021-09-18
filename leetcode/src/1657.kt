class Solution1657 {
    fun closeStrings(word1: String, word2: String): Boolean {
        val occurrencies = Array(3) { IntArray(30) }

        if (word1.length != word2.length) return false
        word1.forEachIndexed { index, char ->
            occurrencies[0][char - 'a']++
            occurrencies[1][word2[index] - 'a']++
            occurrencies[2][char - 'a']++
        }
        run {
            occurrencies[0].forEachIndexed { index, count ->
                if (index == 29) return true
                if (occurrencies[1][index] != count) {
                    val replacement = canGetFrom(occurrencies[0], occurrencies[1][index], index)
                    if (replacement == -1 || count == 0 || occurrencies[1][index] == 0) {
                        return@run
                    } else {
                        swap(occurrencies[0], index, replacement)
                    }
                }
            }
        }
        occurrencies[1].forEachIndexed { index, count ->
            if (index == 29) return true
            if (occurrencies[2][index] != count) {
                val replacement = canGetFrom(occurrencies[1], occurrencies[2][index], index)
                if (replacement == -1 || count == 0 || occurrencies[2][index] == 0) {
                    return false
                } else {
                    swap(occurrencies[1], index, replacement)
                }
            }
        }
        return false
    }

    private fun swap(arr: IntArray, i: Int, j: Int) {
        val tmp = arr[i]
        arr[i] = arr[j]
        arr[j] = tmp
    }

    fun canGetFrom(fromArray: IntArray, target: Int, index: Int): Int {
        for (ind in index + 1 until fromArray.size) {
            if (fromArray[ind] == target) return ind
        }
        return -1
    }
}

fun main() {
    val s = Solution1657()
    println(s.closeStrings("aabbbc", "abbccc"))
    println(s.closeStrings("cabbba", "aabbss"))
    println(s.closeStrings("uau", "ssx"))

}