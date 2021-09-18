class Solution1031 {

    fun maxSumTwoNoOverlap(A: IntArray, L: Int, M: Int): Int {
        val sumArray = IntArray(A.size){
            A[it]
        }
        for (element in 1 until A.size) {
            sumArray[element] += sumArray[element - 1]
        }
        var answer = 0
        for (outerLoopIndex in L - 1  until A.size ) {
            val outerSum =
                if (outerLoopIndex == L - 1) sumArray[outerLoopIndex] else sumArray[outerLoopIndex] - sumArray[outerLoopIndex - L]
            for (innerLoopIndex in outerLoopIndex + M until A.size) {
                answer = kotlin.math.max(answer, outerSum + sumArray[innerLoopIndex] - sumArray[innerLoopIndex - M ])
            }
            for (innerLoopIndex in M until outerLoopIndex - L - 1) {
                answer = kotlin.math.max(answer, outerSum + sumArray[innerLoopIndex] - sumArray[innerLoopIndex - M ])
            }
        }
        for (outerLoopIndex in M - 1  until A.size ) {
            val outerSum =
                if (outerLoopIndex == M - 1) sumArray[outerLoopIndex] else sumArray[outerLoopIndex] - sumArray[outerLoopIndex - M]
            for (innerLoopIndex in outerLoopIndex + L until A.size) {
                answer = kotlin.math.max(answer, outerSum + sumArray[innerLoopIndex] - sumArray[innerLoopIndex - L ])
            }
            for (innerLoopIndex in L until outerLoopIndex - M - 1) {
                answer = kotlin.math.max(answer, outerSum + sumArray[innerLoopIndex] - sumArray[innerLoopIndex - L ])
            }
        }
        return answer
    }
}

fun main() {
    val s = Solution1031()
    print(s.maxSumTwoNoOverlap(intArrayOf(2,1,5,6,0,9,5,0,3,8), 4 , 3))
}