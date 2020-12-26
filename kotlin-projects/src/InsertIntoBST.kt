fun main() {
    val solution5 = Solution5()
    val root = TreeNode(4).apply {
        left = TreeNode(2).apply {
            left = TreeNode(1)
            right = TreeNode(3)
        }
        right = TreeNode(7)
    }
    solution5.insertIntoBST(root, 5)
    print(root.toString())
}


class Solution5 {
    fun insertIntoBST(root: TreeNode?, `val`: Int): TreeNode? {
        traverse(root, `val`)
        return root
    }


    fun traverse(root: TreeNode?, `val`: Int) : TreeNode? {
        when {
            root == null -> return TreeNode(`val`)
            root.`val` > `val` -> root.left= traverse(root.left, `val`)
            else -> root.right= traverse(root.right, `val`)
        }
        return root
    }
}