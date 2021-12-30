import kotlin.math.abs
class Solution65A{

        fun checkAlmostEquivalent(word1: String, word2: String): Boolean {
            val occA = IntArray(26)
            val occB = IntArray(26)

            word1.forEach {
                occA[it-'a']++
            }
            word2.forEach {
                occB[it-'a']++
            }
            occA.forEachIndexed {index, it->
                if(abs(it-occB[index]) > 3 ) return false
            }
            return true
        }


}

fun main() {
    val s = Solution65A()
}