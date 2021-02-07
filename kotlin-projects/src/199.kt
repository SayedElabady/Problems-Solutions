class Solution199 {
    fun rightSideView(root: TreeNode?): List<Int> {
        val levels = Array(1000) { mutableListOf<Int>() }
        if (root != null)
            traverse(root, 0, levels)
        else
            return listOf()
        val answer = mutableListOf<Int>()



        return levels.filter { it.isNotEmpty() }.map { it.last() }
    }


    fun traverse(node: TreeNode, level: Int, levels: Array<MutableList<Int>>) {
        levels[level].add(node.`val`)
        if (node.left != null) traverse(node.left!!, level + 1, levels)
        if (node.right != null) traverse(node.right!!, level + 1, levels)
    }
}