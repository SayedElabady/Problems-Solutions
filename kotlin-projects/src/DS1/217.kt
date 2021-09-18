package DS1

class Solution217 {
    fun containsDuplicate(nums: IntArray): Boolean {
        val hashmap = HashMap<Int, Boolean>()
        nums.forEach {
            if (hashmap[it] == true)
                return true
            hashmap[it] = true
        }
        return false
    }
}