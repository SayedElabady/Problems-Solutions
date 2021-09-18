package Algo1

class Solution567 {
    fun checkInclusion(s1: String, s2: String): Boolean {
        val firstOcc = IntArray(28)
        s1.forEach { firstOcc[it - 'a']++ }
        if (s2.length < s1.length) return false
        var left = 0
        var right = s1.length - 1
        while (right < s2.length) {
            if(checkOcc(s2,left,right, firstOcc))return true
            right++
            left++
        }
        return false
    }

    fun checkOcc(string: String, left: Int, right: Int, target: IntArray): Boolean {
        val occ = IntArray(28)
        (left..right).forEach { occ[string[it] - 'a']++ }
        occ.forEachIndexed { index, i ->
            if (i != target[index]) return false
        }
        return true
    }
}