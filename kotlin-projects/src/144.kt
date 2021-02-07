class Solution144 {

    fun preorderTraversal(root: TreeNode?): List<Int> {
        val ans = mutableListOf<Int>()
        traverse(root, ans)
        return ans
    }

    fun traverse(node: TreeNode?, ans: MutableList<Int>){
        if(node == null) return
        ans.add(node.`val`)
        traverse(node.left, ans)
        traverse(node.right, ans)
    }
}