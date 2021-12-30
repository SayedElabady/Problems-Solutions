import kotlin.math.max
import java.util.*


class Solution65C{
    fun maximumBeauty(items: Array<IntArray>, queries: IntArray): IntArray {
        items.sortBy { it[0] }
        val keys: NavigableMap<Int,Int> = TreeMap<Int, Int>()
        items.forEach {
            keys[it[0]] = max(keys.getOrDefault(it[0], it[1]), it[1])
        }
        val answers = IntArray(queries.size)

        keys.forEach { key, value ->
            val prevois = keys.lowerEntry(key)
            if(prevois != null) {
                keys[key] = max(value, prevois.value)
            }
        }
        val keysList = keys.keys.toList()
        queries.forEachIndexed {index, it ->
            if(it > keys.lastKey()){
                answers[index] = keys.lastEntry().value
            }else if(it<keys.firstKey()){
                answers[index] = 0
            }else{
                answers[index] = keys[keysList[searchForAnswers(keysList, it)]]!!
            }
        }
        return answers
    }

    fun searchForAnswers(keys: List<Int>, value: Int): Int{
        var left = 0
        var right = keys.size - 1
        while (left < right){
            val mid = (left + right)/2
            if(keys[mid] == value){
                return mid
            }else if(keys[mid] > value){
                right = mid-1
            }else{
                left = mid
            }
        }
        return right
    }

}

fun main() {
    val s = Solution65C()

    s.maximumBeauty(arrayOf(intArrayOf(1,2), intArrayOf(3,2), intArrayOf(2,4), intArrayOf(5,6), intArrayOf(3,5)),
         intArrayOf(1,2,3,4,5,6))
}