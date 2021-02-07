class Solution141 {
    fun hasCycle(head: ListNode?): Boolean {
        val map = HashMap<Int, Boolean>()
        var current = head
        while (current!= null){
            if(map[current.`val`]==true) return true
            map[current.`val`] = true
            current = current.next
        }
        return false
    }
}