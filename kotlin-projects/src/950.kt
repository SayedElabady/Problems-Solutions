import java.util.*

fun main() {
    val soultion = Solution11()
    print(soultion.deckRevealedIncreasing(intArrayOf(17, 13, 11, 2, 3, 5, 7)))

}

class Solution11 {
    fun deckRevealedIncreasing(deck: IntArray): IntArray {
        var queuq = ArrayDeque<Int>()
        for(i in 0 until deck.size)
            queuq.add(i)
        var ret = IntArray(deck.size){0}
        deck.sort()
        var i =0
        while(queuq.isNotEmpty()){
            if(i < deck.size)
            ret[queuq.pollFirst()] = deck[i++]
            if(queuq.isNotEmpty())
                queuq.add(queuq.pollFirst())
        }
        return ret
    }
}