class Solution418 {
    fun wordsTyping(sentence: Array<String>, rows: Int, cols: Int): Int {
        var row = 0
        var col = 0
        var index = 0
        var answer = 0
        while(true){
            if(row == rows) return answer
            if(canPlaceWord(col, cols, sentence[index].length)){
                col+=sentence[index].length
                if(col==cols){
                    row++
                    col = 1
                }else{
                    col++
                }
                index++
                if(index == sentence.size){
                    index =0
                    answer++
                }
            }else{
                row++
                col = 0
            }
        }
    }

    fun canPlaceWord(col: Int, cols: Int, wordLength: Int): Boolean{
        return cols-col >= wordLength
    }
}

fun main() {
    val s = Solution418()
    s.wordsTyping(arrayOf("f", "b", "a"),8,7)
}