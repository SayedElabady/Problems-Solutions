class Solution137 {
    fun singleNumber(nums: IntArray): Int {
        val map = mutableMapOf<Int, Int>()
        nums.forEach {
            if (map[it] == null) {
                map[it] = 0
            }
            map[it] = map[it]!! + 1
            if (map[it] == 3) {
                map.remove(it)
            }
        }
        map.forEach {  (key, value) ->
            if (value == 1) {
                return key
            }
        }
        return -1
    }
}

fun main() {
    val s = Solution137()
    println(s.singleNumber(intArrayOf(2,2,3,2)))
}