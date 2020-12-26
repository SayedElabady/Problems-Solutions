fun main() {
    val test = Solution()
    val s = TreeNode(3).apply {
        left = TreeNode(4).apply {
            left = TreeNode(1)
                .apply {
                  //  right = TreeNode(0)
                }
            right = TreeNode(2)
        }
        right = TreeNode(5)
    }
    val t = TreeNode(4).apply {
        left = TreeNode(1)
        right = TreeNode(2)
    }
    println(test.isSubtree(s, t))

}

// Example:
var ti = TreeNode(5)
var v = ti.`val`

// Definition for a binary tree node.
class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun isSubtree(s: TreeNode?, t: TreeNode?): Boolean {

        if(t == null)
            return true
        if(s == null)
            return false
        if (isNodeEqual(s, t))
            return true
        else
            return (isSubtree(s?.left, t) || isSubtree(s?.right, t))
    }

    fun isNodeEqual(first: TreeNode?, second: TreeNode?): Boolean {
        if (second == null && first == null) return true

        if(first != null && second != null)
       return (first?.`val` == second?.`val` && isNodeEqual(first?.right, second?.right) && isNodeEqual(
            first?.left,
            second?.left
        ))
        return false
    }
}