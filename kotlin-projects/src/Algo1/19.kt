package Algo1

class Solution19 {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        val nodes = mutableListOf<ListNode>()

        var current = head
        while (current != null) {
            nodes.add(current)
            current = current.next
        }
        if (n == nodes.size && nodes.size > 1) return head?.next
        nodes.removeAt(nodes.size - n)
        return when {
            nodes.isEmpty() -> null
            n == 1 -> {
                nodes[nodes.size - n].next = null
                head
            }
            else -> {
                nodes[nodes.size - n].next = nodes[nodes.size - n + 1]
                head
            }
        }
    }
}