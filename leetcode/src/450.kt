class Solution450 {
    fun deleteNode(root: TreeNode?, key: Int): TreeNode? {
        if (root == null) return null
        if (root.`val` == key) {
            if (root.left == null && root.right == null) return null
            return getAfterDelete(root)
        }
        if (key > root.`val`) root.right = deleteNode(root.right, key)
        else if (key < root.`val`) root.left = deleteNode(root.left, key)
        return root
    }

    fun getAfterDelete(node: TreeNode): TreeNode {
        if (node.left != null) {
            if (node.right != null) {
                getNodeOfSubTree(node.left!!, node.right!!)
            }
            return node.left!!
        }
        return node.right!!

    }

    fun getNodeOfSubTree(root: TreeNode, current: TreeNode) {
        root.insert(TreeNode(current.`val`))
        if (current.left != null)
            getNodeOfSubTree(root, current.left!!)
        if (current.right != null)
            getNodeOfSubTree(root, current.right!!)

    }
}

fun TreeNode.insert(node: TreeNode) {
    if (node.`val` > this.`val`) {
        if (this.right != null) this.right!!.insert(node)
        else this.right = node
    } else {
        if (this.left != null) this.left!!.insert(node)
        else this.left = node
    }
}

fun main() {
    val s = Solution450()
    val k = TreeNode(5).apply {
        left = TreeNode(3).apply {
            left = TreeNode(2)
            right = TreeNode(4)
        }
    }

    s.deleteNode(k, 3)
}