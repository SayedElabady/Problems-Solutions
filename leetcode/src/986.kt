import kotlin.math.max
import kotlin.math.min



class Solution986 {
//    fun intervalIntersection(A: Array<IntArray>, B: Array<IntArray>): Array<IntArray> {
//        var st = 0
//        var nd = 0
//        var ans = mutableListOf<IntArray>()
//        while (st <= A.size - 1 && nd <= B.size - 1) {
//            if (A[st][0] >= B[nd][0] && A[st][0] <= B[nd][1]) {
//                ans.add(intArrayOf(A[st][0], min(A[st][1], B[nd][1])))
//            } else if (A[st][1] >= B[nd][0] && A[st][1] <= B[nd][1]) {
//                ans.add(intArrayOf(max(A[st][0], B[nd][0]), A[st][1]))
//            } else if (B[nd][0] >= A[st][0] && B[nd][0] <= A[st][1]) {
//                ans.add(intArrayOf(B[nd][0], min(B[nd][1], A[st][1])))
//            }else if (B[nd][1] >= A[st][0] && B[nd][1] <= A[st][1]) {
//                ans.add(intArrayOf(max(B[nd][0], A[st][0]), B[nd][1]))
//            }
//            if (A[st][1] > B[nd][1])
//                nd++
//            else
//                st++
//        }
//        return ans.toTypedArray()
//    }

    fun intervalIntersection(firstList: Array<IntArray>, secondList: Array<IntArray>): Array<IntArray> {
        if(firstList.isEmpty() || secondList.isEmpty()) return emptyArray()
        var firstPointer = 0
        var secondPointer = 0

        val answer = mutableListOf<IntArray>()

        while(firstPointer < firstList.size && secondPointer < secondList.size){
            if(firstPointer == firstList.size) break
            var intervalStart = max(secondList[secondPointer][0], firstList[firstPointer][0])
            var intervalEnd = min(firstList[firstPointer][1], secondList[secondPointer][1])

            if(secondList[secondPointer][1] <= firstList[firstPointer][1]){
                secondPointer++
            }else firstPointer++
            if(intervalEnd>= intervalStart)
                answer.add(intArrayOf(intervalStart, intervalEnd))
        }
        return answer.toTypedArray()
    }
}
fun main() {

    val sa = Solution986()
//    print(
//        sa.intervalIntersection(
//            arrayOf(intArrayOf(0, 2), intArrayOf(5, 10), intArrayOf(13, 23), intArrayOf(24, 25)),
//            arrayOf(intArrayOf(1, 5), intArrayOf(8, 12), intArrayOf(15, 24), intArrayOf(25, 26))
//        )
//    )

    print(
        sa.intervalIntersection(
            arrayOf(intArrayOf(0, 4), intArrayOf(7, 8), intArrayOf(12, 29)),
            arrayOf(intArrayOf(0, 10), intArrayOf(14, 15), intArrayOf(18, 20))
        )
    )
}
