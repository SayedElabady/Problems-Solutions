class Solution1423 {
    fun maxScore(cardPoints: IntArray, k: Int): Int {
        val N = cardPoints.size

        val pre = IntArray(N)
        val after = IntArray(N)
        pre[0] = cardPoints[0]
        after[N-1] = cardPoints.last()

        for(index in 1 until N){
            pre[index]+=pre[index-1] + cardPoints[index]
            after[N - 1 - index] = after[N - index] + cardPoints[N - 1 - index]
        }
        if(k == N) return pre[N-1]
        var answer = 0
        for(counter in 0 until k){
            answer = maxOf(answer, pre[counter] + after[N-k-counter+1])
        }
        return answer
    }
}

fun main() {
    val s = Solution1423()
    //s.maxScore(intArrayOf(1,79,80,1,1,1,200,1), 3)
    s.maxScore(intArrayOf(1,2,3,4,5,6,1), 3)

}