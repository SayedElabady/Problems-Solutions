class Solution445 {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var firstNumber = ""
        var secondNumber = ""
        var currentNode = l1
        while (currentNode != null) {
            firstNumber += currentNode.`val`.toString()
            currentNode = currentNode.next
        }
        currentNode = l2
        while (currentNode != null) {
            secondNumber += currentNode.`val`
            currentNode = currentNode.next
        }
        val sum = if (firstNumber.length > secondNumber.length) {
            add(secondNumber.reversed(), firstNumber.reversed())
        } else add(firstNumber.reversed(), secondNumber.reversed())
        val root = ListNode(0)
        var prev = root
        sum.forEach {
            prev.next = ListNode(it.toString().toInt())
            prev = prev.next!!
        }
        if (sum.isEmpty()) return root
        return root.next
    }

    fun add(shortestNumber: String, longestNumber: String): String {
        var carry = 0
        var sumString = ""
        for (index in 0 until shortestNumber.length) {
            val numberSum = shortestNumber[index].toString().toInt() + longestNumber[index].toString().toInt() + carry
            sumString += numberSum % 10
            carry = numberSum / 10
        }
        for (index in shortestNumber.length until longestNumber.length) {
            val numberSum = longestNumber[index].toString().toInt() + carry
            sumString += numberSum % 10
            carry = numberSum / 10
        }
        if (carry != 0) sumString += carry.toString()
        return sumString.reversed()
    }
}

fun main() {
    val first = ListNode(7).apply {
        next = ListNode(2).apply {
            next = ListNode(4).apply {
                next = ListNode(3)
            }
        }
    }
    val second = ListNode(5).apply {
        next = ListNode(6).apply {
            next = ListNode(4)
        }
    }

    val s = Solution445()
    s.addTwoNumbers(first, second)
    s.addTwoNumbers(ListNode(5), ListNode(5))


}