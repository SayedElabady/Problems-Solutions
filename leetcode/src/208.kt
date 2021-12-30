//class Node {
//    val children = Array<Node?>(27) { null }
//    var isWord = false
//}
//
//private class Trie {
//    val root = Node()
//
//    fun insert(word: String) {
//        var node = root
//        var index = 0
//        while (index != word.length) {
//            if (node.children[word[index] - 'a'] == null) node.children[word[index] - 'a'] = Node()
//            node = node.children[word[index] - 'a']!!
//            index++
//        }
//        node.isWord = true
//    }
//
//    fun search(word: String): Boolean {
//        var node = root
//        var index = 0
//        while (index != word.length) {
//            if (node.children[word[index] - 'a'] == null) return false
//            node = node.children[word[index] - 'a']!!
//            index++
//        }
//        return node.isWord
//    }
//
//    fun startsWith(prefix: String): Boolean {
//        var node = root
//        var index = 0
//        while (index != prefix.length) {
//            if (node.children[prefix[index] - 'a'] == null) return false
//            node = node.children[prefix[index] - 'a']!!
//            index++
//        }
//        return true
//    }
//
//}
