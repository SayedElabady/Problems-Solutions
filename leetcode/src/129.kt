class Solution129 {
    fun sumNumbers(root: TreeNode?): Int {
        return traverse(root!!, 0)
    }

    fun traverse(node: TreeNode, number: Int): Int {

        if (node.left == null && node.right == null)
            return number * 10 + node.`val`
        var totalSum = 0
        if (node.left != null) {
            totalSum += traverse(node.left!!, number * 10 + node.`val`)
        }
        if (node.right != null) {
            totalSum += traverse(node.right!!, number * 10 + node.`val`)
        }
        return totalSum

    }
}