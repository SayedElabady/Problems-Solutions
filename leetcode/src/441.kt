class Solution441{
    fun arrangeCoins(n: Int): Int {

        return searchForAnswer(n)
    }

    fun searchForAnswer(target: Int): Int{
        var left = 1L
        var right = 100000L

        while(left < right){
            val mid = (left + right).shr(1)
            if((mid*(mid+1)/2) < target){
                left = mid+1
            }else right = mid-1

        }
        
        return left.toInt()
    }

}

fun main() {
    val s = Solution441()
    s.arrangeCoins(5)
}