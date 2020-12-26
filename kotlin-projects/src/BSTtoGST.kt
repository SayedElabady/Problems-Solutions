class Solution4 {
    var sum = 0
    fun bstToGst(root: TreeNode?): TreeNode? {
        calculateSum(root)
        return root
    }

    fun calculateSum(node: TreeNode?) {
        if (node == null) return
        calculateSum(node.right)
        sum += node.`val`
        node.`val` += sum
        calculateSum(node.left)
    }
}