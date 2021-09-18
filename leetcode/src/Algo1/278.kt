package Algo1

abstract class VersionControl() {
    abstract fun firstBadVersion(n: Int): Int
    fun isBadVersion(version: Int): Boolean {
        return false
    }
}

class Solution : VersionControl() {
    override fun firstBadVersion(n: Int): Int {
        var left = 1
        var right = n
        var mid: Long = 0
        while (left <= right) {
            mid = (left.toLong() + right.toLong() + 1) / 2
            when {
                isBadVersion(mid.toInt()) -> right = mid.toInt()
                else -> left = mid.toInt() + 1
            }
        }
        if(isBadVersion(mid.toInt())) return mid.toInt()
        return mid.toInt() +1
    }
}