package Algo1

import July.TreeNode

class Solution617 {
    fun mergeTrees(root1: TreeNode?, root2: TreeNode?): TreeNode? {
        if(root1==null) return root2
        traverse(root1, root2)
        return root1
    }

    fun traverse(root1: TreeNode?, root2: TreeNode?) {
        if (root2 == null) return
        root1?.`val` = root1?.`val`?.plus(root2.`val`)!!
        if (root1.right == null) {
            root1.right = root2.right
        } else {
            traverse(root1.right, root2.right)
        }
        if (root1.left == null) {
            root1.left = root2.left
        } else {
            traverse(root1.left, root2.left)
        }
    }
}