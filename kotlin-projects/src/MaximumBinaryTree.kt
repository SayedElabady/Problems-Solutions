import com.sun.source.tree.Tree
import kotlin.math.max
fun main(){
    val solution6 = Solution6()
    print(solution6.constructMaximumBinaryTree(intArrayOf(3,2,1,6,0,5)))
}
class Solution6 {
    fun constructMaximumBinaryTree(nums: IntArray): TreeNode? {
        //     var visited = BooleanArray(1000) { false }
        return build(nums, 0, nums.size-1)
    }

    fun build(nums: IntArray, start: Int, end: Int): TreeNode? {
        if (start >= end) return null
        val max = findMax(nums, start, end)
        var node = TreeNode(nums[max])
        node.left = build(nums, start, max-1)
        node.right = build(nums, max + 1, end)
        return node

    }

    fun findMax(nums: IntArray, start: Int, end: Int): Int {
        var maxIndex = start
        for (i in start..end) {
            if (nums[i] > nums[maxIndex])
                maxIndex = i
        }
        return maxIndex
    }
}