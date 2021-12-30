class Solution10LC {
    fun isMatch(s: String, p: String): Boolean {

        val dp = Array(s.length+1){ BooleanArray(p.length+1)}
        dp[0][0] = true
        (1 until s.length).forEach{
            if(s[it]=='*') dp[0][it+1]=dp[0][it-1]
        }

        for(textIndex in 0 until s.length){
            for(regexIndex in 0 until p.length){
                if(s[textIndex] == p[regexIndex] || p[regexIndex] == '.'){
                    dp[textIndex+1][regexIndex+1] = dp[textIndex][regexIndex]
                }else if(p[regexIndex]== '*'){
                    dp[textIndex+1][regexIndex+1] = dp[textIndex+1][regexIndex-1]
                    if(s[textIndex] == p[regexIndex-1] || p[regexIndex-1] == '.'){
                        dp[textIndex+1][regexIndex+1] = dp[textIndex+1][regexIndex+1].or(dp[textIndex+1][regexIndex])
                    }
                }else
                    dp[textIndex+1][regexIndex+1] = false
            }
        }

        return dp[s.length][p.length]
    }
}

fun main() {
    val s = Solution10LC()
   // s.isMatch("xabc", "xa*.*")
    s.isMatch("aa", "a*")

}