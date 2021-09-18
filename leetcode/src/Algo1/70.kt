package Algo1

class Solution70 {

    fun climbStairs(n: Int): Int {
        val calculated = IntArray(50) { -1 }
        return traverse(n, calculated)
    }

    fun traverse(remaining: Int, calculated: IntArray): Int {
        if (remaining == 0)
            return 1
        if (calculated[remaining] != -1)
            return calculated[remaining]

        calculated[remaining] = traverse(remaining - 1, calculated) + traverse(remaining - 2, calculated)
        return calculated[remaining]
    }

}