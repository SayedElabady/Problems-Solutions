package Algo1

class Solution231 {
    fun isPowerOfTwo(n: Int): Boolean {
        var number = n
        if(number == 2 || number == 1) return true
        while (number != 0) {
            if(number == 2) return true
            if(number%2==1) return false
            number /= 2

        }
        return false
    }
}