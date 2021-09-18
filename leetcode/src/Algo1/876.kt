package Algo1

class Solution876 {
    fun middleNode(head: ListNode?): ListNode? {
        var count = 0
        var current = head
        while (current != null) {
            count++
            current = current.next
        }
        count /= 2
        current = head
        while (count != 0) {
            current = current?.next
            count--
        }
    return current
    }
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}