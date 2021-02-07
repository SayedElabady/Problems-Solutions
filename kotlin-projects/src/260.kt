class Solution260 {
    fun singleNumber(nums: IntArray): IntArray {
        val map = mutableMapOf<Int, Int>()
        nums.forEach {
            map[it] = map.getOrDefault(it, 0) + 1
        }
        val answer = IntArray(2)
        var index = 0
        map.forEach {  (key, value) ->
            if (value == 1) {
                answer[index++] = key
            }
        }
        return answer
    }
}
fun main() {
    val s = Solution260()
    println(s.singleNumber(intArrayOf(2,3,2,4)).forEach {
        println(it)
    })
}