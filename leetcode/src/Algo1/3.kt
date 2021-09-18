package Algo1

import kotlin.math.max

class Solution3 {
    fun lengthOfLongestSubstring(s: String): Int {
        val occ = mutableMapOf<Char, Int>()
        var answer = 0
        var left = 0
        var right = 0
        while (left < s.length){

            occ[s[left]] = occ.getOrDefault(s[left], 0) + 1
            if(occ.get(s[left])!! >1){
                while (occ.get(s[left])!! >1){
                    occ[s[right]]=occ.getOrDefault(s[right], 0) - 1
                    right++
                }
            }
            left++
            answer = max(answer, left-right)
        }
        return answer
    }
}

fun main() {
    val s = Solution3()
    s.lengthOfLongestSubstring("")
}