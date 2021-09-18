package Algo1

class Solution206 {
    fun reverseList(head: ListNode?): ListNode? {
        if (head?.next == null) return head
        var current = head
        val nodes = mutableListOf<ListNode>()

        while (current != null) {
            nodes.add(ListNode(current.`val`))
            current = current.next
        }
        var root = nodes.last()
        val answer = root
        for (index in nodes.size - 2 downTo 0) {
            root?.next = nodes[index]
            root  = root?.next!!
        }
        return answer
    }
}