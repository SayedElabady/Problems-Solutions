import com.sun.source.tree.Tree
import kotlin.math.abs

class Solution979 {
    var ans = 0
    fun distributeCoins(root: TreeNode?): Int {
        solve(root)
        return ans
    }

    fun solve(node: TreeNode?): Int {
        if (node == null) return 0
        val left = solve(node.left)
        val right = solve(node.right)
        ans += abs(left) + abs(right)
        return right + left + node.`val` - 1
    }
}