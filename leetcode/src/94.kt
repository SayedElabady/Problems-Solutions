import com.sun.source.tree.Tree
import java.util.*
import kotlin.collections.HashMap

/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution94 {
    fun inorderTraversal(root: TreeNode?): List<Int> {
        val deque = ArrayDeque<TreeNode>()
        if(root==null) return emptyList()
        val proccessed = HashMap<TreeNode, Boolean>()
        val answer = mutableListOf<Int>()
        deque.addFirst(root)
        while(deque.isNotEmpty()){
            val last = deque.last
            if(last.left!=null && !proccessed.contains(last)){
                deque.addLast(last.left)
                continue
            }
            deque.removeLast()
            proccessed[last] = true
            answer.add(last.`val`)
            if(last.right!=null){
                deque.addLast(last.right)
            }
        }
        return answer
    }
}

fun main() {
    val s = Solution94()
    val root = TreeNode(1).apply {
        right = TreeNode(2).apply {
            left = TreeNode(3)
        }
    }
    s.inorderTraversal(root)
}