/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
import com.sun.source.tree.Tree
import kotlin.math.max
import kotlin.math.min

fun TreeNode.getNumberOfNodes(): Int {
    if (this.left == null && this.right == null) return 1
    var answer = 1
    if (this.left != null) {
        answer += this.left!!.getNumberOfNodes()
    }
    if (this.right != null) {
        answer += this.right!!.getNumberOfNodes()
    }
    return answer
}

class Solution333 {

    val hashTable = HashMap<TreeNode, Pair<Int, Int>>()
    var answer = 0
    fun largestBSTSubtree(root: TreeNode?): Int {
        if (root == null) return 0
        calculateAnswer(root)
        return answer
    }

    fun isValidBST(root: TreeNode): Boolean {
        if (root.left == null && root.right == null) return true
        var answer = true
        if (root.left != null) {
            val leftMinMax = getMinMax(root.left!!)
            answer = answer.and(root.`val` > leftMinMax.second)
        }
        if (root.right != null) {
            val rightMinMax = getMinMax(root.right!!)
            answer = answer.and(root.`val` < rightMinMax.first)
        }
        return answer
    }

    fun getMinMax(node: TreeNode): Pair<Int, Int> {
        if (hashTable.contains(node)) return hashTable[node]!!
        if (node.left == null && node.right == null) {
            hashTable[node] = node.`val` to node.`val`
            return hashTable[node]!!
        }
        var min = node.`val`
        var max = node.`val`
        if (node.left != null) {
            val leftMinMax = getMinMax(node.left!!)
            min = min(min, leftMinMax.first)
            max = max(max, leftMinMax.second)
        }
        if (node.right != null) {
            val rightMinMax = getMinMax(node.right!!)
            min = min(min, rightMinMax.first)
            max = max(max, rightMinMax.second)
        }
        hashTable[node] = min to max
        return hashTable[node]!!

    }

    fun calculateAnswer(root: TreeNode?) {
        if (root == null) return
        if (isValidBST(root)) {
            answer = max(answer, root.getNumberOfNodes())
            return
        }
        if (root.left != null) {
            calculateAnswer(root.left)
        }
        if (root.right != null) {
            calculateAnswer(root.right)
        }

    }
}

fun main() {
    val s = Solution333()
    val node = TreeNode(4).apply {
        left = TreeNode(2).apply {
            left = TreeNode(2)
                .apply {
                      left = TreeNode(2)
                }
            right = TreeNode(3)
        }
        right = TreeNode(7)
    }
    s.largestBSTSubtree(node)
}
