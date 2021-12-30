
//class Solution328 {
////    fun oddEvenList(head: ListNode?): ListNode? {
////        val firstEven = head?.next ?: return head
////        var current = head
////        while (current?.next != null){
////
////            current = current.next?.next
////        }
////    }
//}


class Solution328 {
    fun oddEvenList(head: ListNode?): ListNode? {
        var odd = head
        var even = head?.next
        val evenHead = head?.next
        while(even != null && odd != null){
            odd?.next = even.next
            even.next = even.next?.next
            odd = odd.next
            even = even.next
        }
        odd?.next = evenHead
        return head
    }
}
class ListNode(var `val`: Int) {
    var next: ListNode? = null
}
fun main() {
    val s = Solution328()
    s.oddEvenList(ListNode(1).apply {
        next = ListNode(2).apply { next = ListNode(3).apply { next = ListNode(4) } }
    })
}