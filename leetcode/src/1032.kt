import java.lang.StringBuilder

class StreamChecker(words: Array<String>) {
    val trie = Trie()

    init {
        words.forEach {
            trie.insert(it.reversed())
        }
    }

    val stream = StringBuilder()
    fun query(letter: Char): Boolean {
      stream.append(letter)
        var node: TrieNode? = trie.root
        stream.reversed().forEach {
            node = node?.getNext(it - 'a')
            if(node == null) return false
            node?.let {
                if(it.isWord) return true
            }
        }
        return false
    }

}

class TrieNode(

) {
    val children: Array<TrieNode?> = Array<TrieNode?>(27) { null }
    var isWord: Boolean = false

    fun getNext(value: Int): TrieNode? {
        return this.children[value]
    }

}

class Trie {
    val root = TrieNode()

    fun insert(word: String) {
        var node = root
        var index = 0
        while (index != word.length) {
            if (node.children[word[index] - 'a'] == null) node.children[word[index] - 'a'] = TrieNode()
            node = node.children[word[index] - 'a']!!
            index++
        }
        node.isWord = true
    }

    fun find(value: Int): TrieNode? {
        return root.children[value]
    }

}

fun main() {
    val streamChecker = StreamChecker(arrayOf("acd", "ak", "kl"))
    streamChecker.query('a')
    streamChecker.query('a')
    streamChecker.query('k')
    streamChecker.query('l')
    streamChecker.query('c')
    streamChecker.query('d')

}
/**
 * Your StreamChecker object will be instantiated and called as such:
 * var obj = StreamChecker(words)
 * var param_1 = obj.query(letter)
 */