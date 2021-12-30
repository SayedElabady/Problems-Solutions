class Solution61 {
    fun rotateRight(head: ListNode?, k: Int): ListNode? {
        if(head == null) return null
        var nodesCount =0
        var current = head
        while(current!= null){
            nodesCount++
            current = current.next
        }

        val rotates = k % nodesCount
        if(rotates == 0) return head
        current = head
        for (iterator in 1 until nodesCount - rotates){
            current = current?.next
        }
        var newHead =current
        current=current?.next
        newHead?.next = null
        newHead = current
        while(current!=null){
            if(current.next!=null)
                current = current.next
            else break
        }
        current?.next = head
        return newHead
    }
}