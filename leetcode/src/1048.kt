class Solution1048 {
    fun longestStrChain(words: Array<String>): Int {
        val dp = IntArray(words.size){1}
        words.sortBy { it.length }
        var answer = 1
        for(index in 0 until words.size){
            for(j in index+1 until words.size){
                //if(words[j].length>words[index].length+1) break
                if(isPredecessor(words[index], words[j])){
                    dp[j] = maxOf(dp[index]+1, dp[j])
                }
            }
            answer = maxOf(answer, dp[index])
        }
        return answer
    }

    fun isPredecessor(word1: String, word2: String): Boolean{
        if(word1.length == word2.length) return false
        var firstIndex = 0
        var secondIndex = 0
        var isTaken = false
        while(secondIndex < word2.length&& firstIndex<word1.length){
            if(word1[firstIndex] != word2[secondIndex]){
                if(isTaken) return false
                isTaken = true
                secondIndex++
            }else{
                firstIndex++
                secondIndex++
            }
        }
        return true
    }
}

fun main() {
        val s = Solution1048()
    s.longestStrChain(arrayOf("xbc","pcxbcf","xb","cxbc","pcxbc"))
}