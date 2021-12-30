import kotlin.math.pow
class Solution779 {
    fun kthGrammar(n: Int, k: Int): Int {
        if(n == 1) return 0
        val power = 2.0.pow( n-1).toInt()
        return calculateKth(n, k, power)
    }

    fun calculateKth(row: Int, k:Int, power: Int): Int{
        if(row == 2){
            if(k ==1) return 0
            else return 1
        }
        val nextPower = power/2
        if(k <= nextPower){
            return calculateKth(row-1, k, nextPower)
        }else if(k <= nextPower + nextPower/2){
            return calculateKth(row-1, (k - nextPower/2), nextPower )
        }else
            return calculateKth(row-1, (k - nextPower+ nextPower/2), nextPower )

    }

}

fun main() {
    val s = Solution779()
    s.kthGrammar(5,7)
}