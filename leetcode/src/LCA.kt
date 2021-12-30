import java.util.*
import kotlin.math.abs

class LCA{

     fun findLCA(head: TreeNode1, first: TreeNode1, second: TreeNode1): TreeNode1?{
        val firstStack = searchForNode(head, first, Stack<TreeNode1>())
        val secondStack = searchForNode(head, second, Stack<TreeNode1>())

        val shorterStack = if(firstStack.size>secondStack.size) secondStack else firstStack
        val longerStack = if(firstStack.size>secondStack.size) firstStack else secondStack

        var diff = abs(firstStack.size - secondStack.size)
        while(diff != 0) {
            longerStack.pop()
            diff--
        }

        while(shorterStack.isNotEmpty()){
            if(shorterStack.peek() == longerStack.peek()) return longerStack.peek()
            shorterStack.pop()
            longerStack.pop()
        }
        return null

    }

    private fun searchForNode(current: TreeNode1, first: TreeNode1, stack: Stack<TreeNode1>): Stack<TreeNode1> {
        if(current.`val` == first.`val`){
            return stack
        }
        for(child in current.children){
            stack.push(child)
            val searchedInThisWay = searchForNode(child, first, stack)
            if(searchedInThisWay.peek().`val` == first.`val`){
                return stack
            }else{
                stack.pop()
            }
        }
        return stack


    }
     class TreeNode1(var `val`: Int) {
        var children: List<TreeNode1> = emptyList()
    }

}

fun main() {
    val s = LCA()
    s.findLCA(LCA.TreeNode1(1).apply {
        children = listOf(LCA.TreeNode1(2).apply {
            children = listOf(LCA.TreeNode1(3).apply {
                children = listOf(LCA.TreeNode1(5))
            },LCA.TreeNode1(4).apply {
                children = listOf(LCA.TreeNode1(6))
            })
        })
    }, LCA.TreeNode1(5),LCA.TreeNode1(6))

}
