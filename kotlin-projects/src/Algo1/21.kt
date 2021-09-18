package Algo1

class Solution21 {
    fun mergeTwoLists(l1: ListNode?, l2: ListNode?): ListNode? {
        if (l1 == null && l2 == null) return null
        if (l1 == null) return l2
        if (l2 == null) return l1

        var leftPointer = l1
        var rightPointer = l2
        var root = if (leftPointer.`val` > rightPointer.`val`) {
            rightPointer = l2.next
            ListNode(rightPointer!!.`val`)
        } else {
            leftPointer = l1.next
            ListNode(leftPointer!!.`val`)
        }
        var current : ListNode?= root
        while (leftPointer != null || rightPointer != null) {
            if(leftPointer == null){
                current?.next = rightPointer
                return root
            }
            if(rightPointer == null){
                current?.next = leftPointer
                return root
            }
            if (leftPointer.`val` > rightPointer.`val`) {
                current?.next = ListNode(rightPointer.`val`)
                rightPointer = rightPointer.next
            } else {
                current?.next = ListNode(leftPointer.`val`)
                leftPointer = leftPointer.next
            }
            current = current?.next
        }
        return root
    }
}