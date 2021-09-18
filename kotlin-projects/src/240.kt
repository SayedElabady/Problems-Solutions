import java.util.*

class Solution240 {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        val list = mutableListOf<Int>()
        matrix.forEach { it.forEach { list.add(it) } }
        list.sort()
        if(Arrays.binarySearch(list.toIntArray(), target) == -1) return false
        return true
    }
}