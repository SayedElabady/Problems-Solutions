import java.util.*

class Solution25 {
    fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
        val range = k
        var startIndex = 0
        val length = getLength(head)
        var newHead : ListNode? = head
        while (true) {
            if (startIndex + range > length) break
            newHead = reverseInRange(newHead, startIndex, startIndex + range-1)
//             if (startIndex + range + range + 1 > length) {
//                 if((length - (startIndex+range)) % 2 == 0&& (length - (startIndex+range)) >0)
//                     reverseInRange(head, startIndex+range, length-1)

//             }
            startIndex += range
        }
        return newHead
    }

    fun getLength(head: ListNode?): Int {
        var current = head
        var length = 0
        while (current != null) {
            length++
            current = current.next
        }
        return length
    }

    fun reverseInRange(head: ListNode?, start: Int, end: Int): ListNode? {
        val stack = Stack<ListNode>()
        var index = 0
        var curr = head
        var beforeRange: ListNode? = null
        while (index != start) {
            beforeRange = curr
            curr = curr?.next
            index++
        }
        for (iterator in index..end) {
            stack.push(curr)
            curr = curr?.next
        }
        val afterReveresed = curr

        val reversedHead = stack.peek()
        curr = stack.pop()
        while (stack.isNotEmpty()) {
            curr?.next = stack.pop()
            curr = curr?.next
        }
        beforeRange?.next = reversedHead
        curr?.next = afterReveresed
        if(start == 0) return reversedHead
        return head
    }
}

fun main() {
    val head2 = ListNode(1).apply {
        next = ListNode(2).apply {
            next = ListNode(3).apply {
                next = ListNode(4).apply { next = ListNode(5) }
            }
        }
    }

    val s = Solution25()
    s.reverseKGroup(head2, 2)
}