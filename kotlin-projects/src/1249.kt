import java.util.*
import kotlin.math.log

class Solution1249 {
    fun minRemoveToMakeValid(s: String): String {
        var counter = 0
        val locationsToBeRemoved: MutableList<Int> = mutableListOf<Int>()
        //lee(t(c)o)de)
        s.forEachIndexed { index, char ->
            if (char == '(') {
                counter++
                locationsToBeRemoved.add(index)
            } else if (char == ')') {
                if (counter == 0) {
                    locationsToBeRemoved.add(index)
                } else {
                    counter--
                    locationsToBeRemoved.removeAt(locationsToBeRemoved.lastIndex)
                }
            }
        }
        var iterator = 0
        return s.filterIndexed { index, _ ->
            if (iterator < locationsToBeRemoved.size && index == locationsToBeRemoved[iterator]) {
                iterator++
                false
            } else true
        }
    }
}

fun main() {
    val d = Solution1249()
    println(d.minRemoveToMakeValid("lee(t(c)o)de)"))
    println(d.minRemoveToMakeValid("a)b(c)d"))
    println(d.minRemoveToMakeValid("))(("))

}