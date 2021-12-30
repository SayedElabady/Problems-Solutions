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
class Solution102 {
    val answer = HashMap<Int, MutableList<Int>>()
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        if(root == null) return emptyList()
       // getLevelOrder(root, 0)

        // val stack = Stack<Pair<TreeNode, Int>>()
        // stack.push(root to 0)
        // var current = root.left
        // while(stack.isNotEmpty() || current!=null){
        //     if(current!=null){
        //         stack.push(current to stack.peek().second + 1)
        //         current = current.left
        //     }else{
        //         if()
        //     }
        // }
        return answer.values.toList()
    }

//    fun getLevelOrder(node: TreeNode, level: Int){
//        if(node.left != null){
//            getLevelOrder(node.left, level + 1)
//        }
//        if(answer.get(level) == null){
//            answer[level] = mutableListOf(node.`val`)
//        }else{
//            answer[level].add(node.`val`)
//        }
//        if(node.right != null){
//            getLevelOrder(node.right, level+1)
//        }
//    }
}