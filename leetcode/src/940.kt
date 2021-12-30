import java.util.*
import kotlin.math.abs

class Solution940 {
        fun distinctSubseqII(s: String): Int {
            val chars = BooleanArray(28)
            val dp = LongArray(s.length+1)
            val MOD = 1_000_000_007
            dp[0]=1
            chars[s[0]-'a'] = true
            for(index in 1 until s.length){
                if(s[index] == s[index-1]){
                    dp[index] = dp[index-1] + ((dp[index-1]+2)/2)
                }else {
                    dp[index] = (dp[index-1] * 2) +1
                    if(chars[s[index]-'a'])
                        dp[index]--
                }
                chars[s[index]-'a']=true
            }
            return ((dp[s.length-1]%MOD)).toInt()
        }

}

fun main() {
    val s = Solution940()
    s.distinctSubseqII("aba")
    val set = TreeMap<Int, Int>()
    set.iterator().forEach {
    }
//    set.add(5)
//    set.add(4)
//    set.add(8)
//    set.add(1)
//    set.add(1)
//
//    println(set.iterator().forEach { println(it) })
}