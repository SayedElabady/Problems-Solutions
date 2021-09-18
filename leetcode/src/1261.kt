class FindElements(root: TreeNode?) {
    val visited = BooleanArray(1000000) { false }

    init {
        root?.`val` = 0
        recover(root)
    }

    private fun recover(transform: TreeNode?) {
        if (transform == null) return
        if (transform.left != null) {
            transform.left!!.`val` = 2 * transform.`val` + 1
            visited[transform.left!!.`val`] = true
            recover(transform.left)
        }
        if (transform.right != null) {
            transform.right!!.`val` = 2 * transform.`val` + 2
            visited[transform.right!!.`val`] = true
            recover(transform.right)
        }
    }

    fun find(target: Int): Boolean {
        return visited[target]
    }


}
