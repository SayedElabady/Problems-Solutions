package Algo1

class Solution46 {
    val answers = mutableListOf<List<Int>>()
    fun permute(nums: IntArray): List<List<Int>> {
        traverse(nums, BooleanArray(nums.size), mutableListOf())
        return answers
    }

    fun traverse(original: IntArray, indices: BooleanArray, nums: MutableList<Int>) {
        if (nums.size == indices.size) {
            answers.add(nums)
        }
        indices.forEachIndexed { index, it ->
            if (!it) {
                val newIndicies = indices.copyOf()
                newIndicies[index] = true
                val newNums = nums.copyOf()
                newNums.add(original[index])
                traverse(original, newIndicies, newNums)
            }
        }

    }

    fun BooleanArray.copyOf(): BooleanArray {
        val res = BooleanArray(this.size) { this[it] }
        return res
    }

    fun MutableList<Int>.copyOf(): MutableList<Int> {
        val res = MutableList(this.size) { this[it] }
        return res
    }


}