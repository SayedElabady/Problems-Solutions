import java.util.*
import kotlin.math.min

class Solution267B {

    fun reverseEvenLengthGroups(head: ListNode?): ListNode? {
        var range = 2
        var startIndex = 1
        val length = getLength(head)
        while (true) {
            if (startIndex + range >= length) break
            reverseInRange(head, startIndex, startIndex + range - 1)
            if (startIndex + range + range + 1 > length) {
                if((length - (startIndex+range)) % 2 == 0 && (length - (startIndex+range)) >0)
                    reverseInRange(head, startIndex+range, length-1)

            }
            startIndex += range + range + 1
            range *= 2
        }
        return head
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
        var head = head
        var x = start
        var y = end

        val stack = Stack<ListNode>()
        var index = 0
        var curr = head
        var beforeRange = curr
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
        return head
    }

}

fun main() {
    val s = Solution267B()
    val head = ListNode(5).apply {
        next = ListNode(2).apply {
            next = ListNode(6).apply {
                next = ListNode(3).apply {
                    next = ListNode(9).apply {
                        next = ListNode(1).apply {
                            next = ListNode(7).apply {
                                next = ListNode(3).apply {
                                    next = ListNode(8).apply {

                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    val head2 = ListNode(2).apply {
        next = ListNode(1).apply {
            next =  ListNode(3).apply {
                next = ListNode(4).apply {next = ListNode(5) }
            }
        }
    }
    s.reverseEvenLengthGroups(head)
}