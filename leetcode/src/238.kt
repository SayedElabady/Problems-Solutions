class Solution238 {
//    fun productExceptSelf(nums: IntArray): IntArray {
//        val N = nums.size
//        val leftMul = IntArray(N) { nums[0] }
//        val rightMul = IntArray(N) { nums.last() }
//        for (index in 0 until N) {
//            if (index != 0) {
//                leftMul[index] = nums[index] * leftMul[index - 1]
//                rightMul[N - index - 1 ] = nums[N - index - 1] * rightMul[N - index]
//            }
//        }
//        val answer = IntArray(N)
//        answer[0] = rightMul[1]
//        answer[N - 1] = leftMul[N - 2]
//        for (index in 1..N - 2) {
//            answer[index] = leftMul[index - 1] * rightMul[index + 1]
//        }
//        return answer
//    }

    fun productExceptSelf(nums: IntArray): IntArray {
        val n = nums.size
        if(n == 2) return intArrayOf(nums[1], nums[0])
        val result = IntArray(n)
        result[n-1] = nums[n-1]
        var index = 1
        while(index != n - 1){
            result[n - index - 1] = nums[n - index - 1] * result[n - index]
            index++
        }

        index = 1
        var acc = nums[0]
        while(index != n-1){
            result[index] = acc * result[index + 1]
            acc = acc * nums[index]
            index++
        }
        result[n-1] = acc
        return result
    }
}

fun main() {
    val s = Solution238()
    s.productExceptSelf(intArrayOf(1,2,3,4))
}