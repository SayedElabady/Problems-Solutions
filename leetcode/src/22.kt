class Solution22 {
    val answer = HashSet<String>()
    val visited = HashMap<Pair<String,Int>, Boolean>()
    fun generateParenthesis(n: Int): List<String> {
        var initString =""
        for(pair in 0 until n){
            initString+="()"
        }


        answer.add(initString)
        traverse(0, initString)
        return answer.sorted().toList()

    }

    fun traverse(index: Int, word: String){
        if(index == word.length-1) return
        if(visited[Pair(word, index)] != null) return
        visited[Pair(word,index)] = true
        var firstClosingIndex = -1
        for(it in index until word.length){
            if(word[it]==')'){
                firstClosingIndex = it
                break
            }
        }
        if(firstClosingIndex != -1){
            (firstClosingIndex+1 until word.length).forEach{
                val newString = word.constructNewString(firstClosingIndex, it)
                answer.add(newString)
                traverse(firstClosingIndex, newString)
                traverse(it, word)

            }
        }

    }

    fun String.constructNewString(oldIndex: Int, newIndex: Int):String{
        return this.substring(0, oldIndex) + this.substring(oldIndex+1, newIndex+1) + this[oldIndex] + this.substring(newIndex+1)
    }

}
fun String.constructNewString(oldIndex: Int, newIndex: Int): String {
    return this.substring(0, oldIndex) + this.substring(oldIndex + 1, newIndex+1) + this[oldIndex] + this.substring(
        newIndex + 1
    )
}
fun main() {
    val s = Solution22()
    s.generateParenthesis(3)

    println("()()()".constructNewString(1,3))
}