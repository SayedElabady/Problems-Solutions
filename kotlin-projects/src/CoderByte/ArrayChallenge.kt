package CoderByte

import java.util.*

val traversedTree = mutableListOf<Int>()

fun ArrayChallenge(strArr: Array<String>): String {
    val nodesQueue = ArrayDeque<TreeNode>()
    val root = TreeNode(strArr[0].toInt())
    nodesQueue.add(root)
    var index = 1
    while (nodesQueue.isNotEmpty()) {
        val requiredForBuilding = nodesQueue.pollFirst()
        if (index >= strArr.size)
            break
        if (strArr[index] != "#") {
            val node = TreeNode(strArr[index].toInt())
            requiredForBuilding.left = node
            nodesQueue.add(node)
        }
        index++
        if (strArr[index] != "#") {
            val node = TreeNode(strArr[index].toInt())
            requiredForBuilding.right = node
            nodesQueue.add(node)
        }
        index++
    }
    dfs(root)
    return traversedTree.joinToString(separator = " ")

}

fun dfs(treeNode: TreeNode) {
    traversedTree.add(treeNode.`val`)
    treeNode.left?.let { dfs(it) }
    treeNode.right?.let { dfs(it) }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun main() {
    println(ArrayChallenge(arrayOf("2", "6", "#")))
}

