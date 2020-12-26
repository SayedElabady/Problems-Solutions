package July

import com.sun.source.tree.Tree
import java.util.*

class SameTree {
    val queue = ArrayDeque<Pair<TreeNode?, TreeNode?>>()
    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        queue.add(Pair(p, q))
        return check(true)
    }

    fun check(right: Boolean): Boolean {
        if(queue.isEmpty()) return true
        val current = queue.pop()
        if (current.first == null && current.second != null ||
            current.second == null && current.first != null
        ) return false

        if (current.first?.`val` != current.second?.`val`) return false

        if (!(current.first?.left == null && current.second?.left == null))
            queue.add(Pair(current.first?.left, current.second?.left))
        if (!(current.first?.right == null && current.second?.right == null))
            queue.add(Pair(current.first?.right, current.second?.right))
        return check(right)
    }
}