import com.sun.source.tree.Tree

fun main() {
    val s8 = S864()
    s8.allPossibleFBT(5).forEach {
        println(it?.`val`.toString() + " " + it?.right?.`val`.toString() + " " + it?.left?.`val`.toString())
    }
}

class S864 {

    fun allPossibleFBT(N: Int): List<TreeNode?> {
        val nodes = mutableListOf<TreeNode?>()
        if (N == 1)
            nodes.add(TreeNode(0))
        else if (N % 2 == 1) {
            for (i in 2..N step 2) {
                val left = allPossibleFBT(i - 1)
                val right = allPossibleFBT(N - i)
                for (leftIdx in 0 until left.size) {
                    for (rightIdx in 0 until right.size) {
                        nodes.add(TreeNode(0))
                        nodes.last()?.right = if (leftIdx == left.size - 1) right[rightIdx] else clone(right[rightIdx])
                        nodes.last()?.left = if (rightIdx == right.size - 1) left[leftIdx] else clone(left[leftIdx])
                    }
                }

            }
        }
        return nodes
    }


    fun clone(treeNode: TreeNode?): TreeNode? {
        val _treeNode = TreeNode(treeNode?.`val`!!)
        treeNode.right?.let { _treeNode.right = clone(treeNode.right!!) }
        treeNode.left?.let { _treeNode.left = clone(treeNode.left!!) }
        return _treeNode
    }
}