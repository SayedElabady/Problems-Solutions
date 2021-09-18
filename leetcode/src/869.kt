class Solution869 {
    fun reorderedPowerOf2(N: Int): Boolean {
        val list = mutableListOf<Int>()
        var number = N
        while (number != 0) {
            list.add(number % 10)
            number /= 10
        }
        var res = false
        getPermutations(list) {
            res = true
        }

        return res
    }

    fun getPermutations(set: List<Int>, onOrderFound: () -> Unit): List<List<Int>> {
        return _allPermutations(set, set.size, onOrderFound)
    }

    fun  _allPermutations(list: List<Int>, fullLength: Int, onOrderFound: () -> (Unit)): List<List<Int>> {
        if (list.isEmpty()) return listOf(emptyList())

        val result: MutableList<List<Int>> = mutableListOf()
        for (i in list.indices) {
            _allPermutations(list - list[i], fullLength, onOrderFound).forEach { item ->
                if (list.size == fullLength) if ((item + list[i])[0] != 0 && isPowerOfTwo((item + list[i]))) {
                    onOrderFound()
                    return result
                }
                result.add(item + list[i])
            }
        }
        return result
    }

    fun isPowerOfTwo(A: List<Int>): Boolean {
        if (A[0] == 0) return false
        var N = 0
        for (x in A)
            N = 10 * N + x

        while (N > 0 && N and 1 == 0)
            N = N shr 1

        return N == 1
    }

}

fun main() {
    val s = Solution869()
    val ss = s.reorderedPowerOf2(1)
    print(ss)
}

