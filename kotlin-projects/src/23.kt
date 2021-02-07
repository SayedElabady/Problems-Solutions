class Solution23 {
    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        val listItems = mutableListOf<Int>()
        lists.forEach {
            var current = it
            while (current != null) {
                listItems.add(current!!.`val`)
                current = current!!.next
            }
        }
        listItems.sort()
        if(listItems.isEmpty()) return null
        val root = ListNode(listItems[0])
        var current = root
        for (index in 1 until listItems.size){
            val newNode = ListNode(listItems[index])
            current.next = newNode
            current = newNode
        }
        return root
    }
}

