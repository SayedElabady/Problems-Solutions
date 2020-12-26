package July

import java.lang.Math.pow
import kotlin.math.max
import kotlin.math.min
import kotlin.math.pow

class MaximumWidthofBinaryTree {

    val visited = ArrayList<TreeNode>()
    fun widthOfBinaryTree(root: TreeNode?): Int {
        val leftLevel = getMaxLevel(root?.left, 1)
        val rightLevel= getMaxLevel(root?.right, 1)
        return max(2.0.pow(min(rightLevel, leftLevel)), 2.0.pow(max(leftLevel,rightLevel))/2).toInt()
    }

    fun getMaxLevel(currentNode: TreeNode?, lvl: Int): Int {
        if (currentNode == null || visited.contains(currentNode)) return lvl-1
        visited.add(currentNode)
        val max = max(getMaxLevel(currentNode.left, lvl+1), getMaxLevel(currentNode.right, lvl+1))
        return max
    }
}

fun main() {
    val s = MaximumWidthofBinaryTree()

}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}