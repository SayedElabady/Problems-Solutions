class Solution1609 {
    fun isEvenOddTree(root: TreeNode?): Boolean {
        val levelsLastValue = Array(1000001) { if (it % 2 == 0) 0 else Int.MAX_VALUE }
        return traverse(root!!, 0, levelsLastValue)
    }

    fun traverse(node: TreeNode, level: Int, levelsLastValue: Array<Int>    ): Boolean {
        var answer = true
        val isEvenOdd = (level % 2 == 0 && node.`val` % 2 != 0) || (level % 2 != 0 && node.`val` % 2 == 0)
        if ((level % 2 == 0 && node.`val` <= levelsLastValue[level])
            || (level % 2 != 0 && node.`val` >= levelsLastValue[level]) || !isEvenOdd
        ) return false
        levelsLastValue[level] = node.`val`
        if (node.left != null)
            answer = answer.and(traverse(node.left!!, level + 1, levelsLastValue))
        if (node.right != null)
            answer = answer.and(traverse(node.right!!, level + 1, levelsLastValue))
        return answer
    }

}

fun main() {
    val treeNode1 = TreeNode(3)
    val treeNode2 = TreeNode(3)
    val treeNode3 = TreeNode(7)
    val treeNode4 = TreeNode(4)
    treeNode4.left = treeNode1
    treeNode4.right = treeNode2
    val treeNode5 = TreeNode(2)
    treeNode5.left = treeNode3
    val treeNode6 = TreeNode(5)
    treeNode6.left = treeNode4
    treeNode6.right = treeNode5
    val s = Solution1609()
    println(s.isEvenOddTree(treeNode6))
}