package June

class LargestDivisibleSubset {

    fun largestDivisibleSubset(nums: IntArray): List<Int> {
        val values = IntArray(1000000)
        nums.forEach {
            values[it] = 1
        }
        val max = 10e5
        var maxSoFar = 1
        var ans = 1
        val limit = max / 2
        var current = 2
        while (current <= limit) {
            val savedCurrent = current
            var numberOfFound = 0
            while (current < max) {
                if (values[current] > 0) numberOfFound++
                current *= current
            }
            if (numberOfFound > maxSoFar) {
                maxSoFar = numberOfFound
                ans = savedCurrent
            }
            current = savedCurrent
            current++
        }
        val ansList = mutableListOf<Int>()
        if (ans != 1) {
            current = ans
            while (current < max) {
                if (values[current] > 0) ansList.add(current)
                current *= current
            }
            if (!ansList.contains(1) && values[1] > 0) ansList.add(1)
        } else {

        }
        return ansList

    }

}

fun main() {
    val l = LargestDivisibleSubset()
    println(l.largestDivisibleSubset(intArrayOf(1, 2, 3)))
    println(l.largestDivisibleSubset(intArrayOf(1, 2, 4, 8)))

}