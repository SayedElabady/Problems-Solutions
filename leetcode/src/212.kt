//class Solution212 {
//    val answer = HashSet<String>()
//    val directions = arrayOf(intArrayOf(0,1), intArrayOf(0,-1), intArrayOf(1,0), intArrayOf(-1,0))
//    fun findWords(board: Array<CharArray>, words: Array<String>): List<String> {
//        val trie = Trie()
//        words.forEach{ trie.insert(it) }
//        val visited = Array(board.size){BooleanArray(board[0].size)}
//        for(row in board.indices){
//            for(col in board[0].indices){
//                val startNode = trie.find(board[row][col])
//                if(startNode != null){
//                    dfs(board, startNode, row, col, visited)
//                }
//            }
//        }
//        return answer.toList()
//
//    }
//
//    fun dfs(board:Array<CharArray>, node: TrieNode, row: Int, col: Int, visited: Array<BooleanArray>){
//        if(node.word != null){
//            answer.add(node.word!!)
//        }
//        visited[row][col] = true
//        for(index in directions.indices){
//            val nextRow = row + directions[index][0]
//            val nextCol = col + directions[index][1]
//            if(nextRow >= 0 && nextRow < board.size && nextCol >=0 && nextCol <board[0].size){
//                val nextNode = node.getNext(board[nextRow][nextCol])
//                if(nextNode != null && !visited[nextRow][nextCol]){
//                    dfs(board, nextNode, nextRow, nextCol, visited)
//                }
//            }
//        }
//        visited[row][col] = false
//
//    }
//
//
//}
//
//class TrieNode(){
//    val children = Array<TrieNode?>(27){ null }
//    var word: String? = null
//}
//
//fun TrieNode.getNext(char: Char): TrieNode?{
//    return this.children[char - 'a']
//}
//
//class Trie{
//    val root = TrieNode()
//
//    fun insert(word: String){
//        var index = 0
//        var current= root
//        while(index != word.length){
//            if(current.children[word[index]-'a'] == null){
//                current.children[word[index] - 'a'] = TrieNode()
//            }
//            current = current.children[word[index] - 'a']!!
//            index++
//        }
//        current.word = word
//    }
//
//    fun find(char: Char): TrieNode?{
//        return root.getNext(char)
//    }
//
//}