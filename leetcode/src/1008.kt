class Solution7 {
    fun bstFromPreorder(preorder: IntArray): TreeNode? {
        var root = TreeNode(preorder[0])
        for(i in 1 until preorder.size)
            place(root , preorder[i])
        return root

    }

    fun place(node: TreeNode?, value: Int){
        if(node == null) return
        if(node.`val` > value){
            if(node.right == null){
                node.right = TreeNode(value)
                return }
            else place(node.right , value)
        }else{
            if(node.left == null){
                node.left = TreeNode(value)
                return }
            else place(node.left , value)
        }
    }
}