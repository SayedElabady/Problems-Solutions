/**
 * Definition for a Node.

 */


class Solution708 {
    class Node(var `val`: Int) {
        var next: Node? = null
    }

    fun insert(head: Node?, insertVal: Int): Node? {
        if (head == null) return Node(insertVal).apply { next = this }
        if (head.next == head) {
            val insertedNode = Node(insertVal)
            head.next = insertedNode
            insertedNode.next = head
            return head
        }
        val nodesMap = HashMap<Node, Boolean>()
//         var largerNode = Node(1000001)
//         var smallerNode = Node(-1000001)

//         var current = head
//         while(!nodesMap.contains(current)){
//             if(current.`val` < insertVal && current.`val` > smallerNode.`val`){
//                 smallerNode = current
//             }else if(current.`val` > insertVal && current.`val` < largerNode.`val`){
//                 largerNode = current
//             }
//             current = current.next
//         }
//         if(largerNode.`val` == 1000001 && smallerNode.`val` == -1000001){
//             insertInto(head, insertValue)
//         }else if(largerNode.`val` == 1000001){
//             insertInto(smallerNode, insertVal)
//         }else {
//             insertInto(largerNode, insertVal)
//         }
        insert(null, head, insertVal, nodesMap)
        return head
    }

    fun insert(prev: Node?, node: Node, value: Int, nodesMap: HashMap<Node, Boolean>): Boolean {

        if (prev != null) {

            if (nodesMap.contains(node)) return false
            nodesMap[node] = true
            if (prev.`val` == value || (prev.`val` < value && node.`val` > value)) {
                val nodeToInsert = Node(value)
                nodeToInsert.next = node
                prev.next = nodeToInsert
                return true
            } else {
                return insert(node, node.next!!, value, nodesMap)
            }

        } else {
            return insert(node, node.next!!, value, nodesMap)
        }
    }
}

fun main() {
    val s = Solution708()
    val node1 = Solution708.Node(1)
    val node3 = Solution708.Node(3)
    val node4 = Solution708.Node(4)
    node1.next = node3
    node3.next = node4
    node4.next = node1
    s.insert(node3, 2)
}