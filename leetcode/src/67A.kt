class Solution67A{
    fun maxSubsequence(nums: IntArray, k: Int): IntArray {
        val sorted = nums.sorted().toIntArray()
        val n = nums.size-1
        val required= sorted.sliceArray(n - k+1..n).toMutableList()
        val answer = mutableListOf<Int>()
        nums.forEach {
            if(required.contains(it)){
                answer.add(it)
                required.remove(it)
            }
        }
        return answer.toIntArray()
    }

}

fun main() {
    val s = Solution67A()
    println()
}