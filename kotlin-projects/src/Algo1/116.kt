package Algo1


class Node(var `val`: Int) {
    var left: Node? = null
    var right: Node? = null
    var next: Node? = null
}


class Solution116 {

    val nodesPerLevel = Array<MutableList<Node>>(15) { mutableListOf()}
    fun connect(root: Node?): Node? {
        if (root == null)
            return null
        traverse(root, 0)
        nodesPerLevel.forEach {
            it.forEachIndexed { index, node ->
                if (index != it.size - 1) {
                    node.next = it[index+1]
                }
            }
        }
        return root
    }

    fun traverse(node: Node, level: Int) {
        nodesPerLevel[level].add(node)
        if (node.left != null)
            traverse(node.left!!, level + 1)
        if (node.right != null)
            traverse(node.right!!, level + 1)

    }
}