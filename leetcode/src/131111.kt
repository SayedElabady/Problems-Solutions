class Solution131313 {
    fun countVowels(word: String): Long {
        val occs = IntArray(word.length+2)
        var answer = 0L
        for(index in 1..word.length){
            val it = word[index-1] - 'a'
            if(it == 0 || it == 4 || it == 8 || it == 14 || it == 20){
                answer += index * word.length
            }
        }


        return answer
    }
}

fun main() {
    val s = Solution131313()
    s.countVowels("aba")
}