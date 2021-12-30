class Solution106 {
    fun buildTree(inorder: IntArray, postorder: IntArray): TreeNode? {
        return build(inorder, postorder)
    }

    fun build(inorder: IntArray, postorder: IntArray): TreeNode?{
        if(inorder.isEmpty()) return null
        if(inorder.size == 1) return TreeNode(inorder[0])

        val root = TreeNode(postorder.last())
        val indexOfRoot = getIndexOf(inorder, postorder.last())
        val lengthOfRight = inorder.size - indexOfRoot - 1
        root.right = build(inorder.copyOfRange(indexOfRoot + 1, inorder.lastIndex + 1),
            postorder.copyOfRange(postorder.size - lengthOfRight - 1, postorder.size - 1))

        root.left = build(inorder.copyOfRange(0, indexOfRoot), postorder.copyOfRange(0, indexOfRoot))

        return root
    }

    fun getIndexOf(array: IntArray, target:Int) : Int{
        array.forEachIndexed{ index, it -> if(it ==target ) return index }
        return 0
    }
}

fun main() {
    val s = Solution106()
    s.buildTree(intArrayOf(9,3,15,20,7), intArrayOf(9,15,7,20,3))
}