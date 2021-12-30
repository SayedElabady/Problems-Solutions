import java.lang.StringBuilder
import kotlin.math.max
import kotlin.math.min

class Solution2075 {
    fun decodeCiphertext(encodedText: String, rows: Int): String {
        val columns = encodedText.length/rows
        var index = 0
        val text = Array(rows){CharArray(columns)}
        var maxConceutiveChars = 0
        for(row in 0 until rows){
            var currentConcutive = 0
            for(column in 0 until columns){
                if(encodedText[index] != ' ') {
                    currentConcutive++
                    maxConceutiveChars = max(maxConceutiveChars,currentConcutive)
                }
                text[row][column] = encodedText[index++]
            }
        }
        var answer = StringBuilder()
        index = 0
        for(iterator in 0 until columns){
            val temp = StringBuilder()
            for(row in 0 until rows){
                if(row+iterator<columns)
                    temp.append(text[row][row+iterator])
            }
            answer.append(temp.toString().trimEnd())
        }

        return answer.toString().trimEnd()
    }
}

fun String.getLastIndexOfNonSpace(): Int {
    for (index in this.length - 1 downTo 0) {
        if (!this[index].isWhitespace()) return index
    }
    return -1
}

fun main() {
    val s = Solution2075()
    s.decodeCiphertext("iveo    eed   l te   olc", 4)
}