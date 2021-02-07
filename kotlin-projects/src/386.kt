class Solution386 {
    fun lexicalOrder(n: Int): List<Int> {
        return (1..n).map { it.toString() }.sorted().map { it.toInt() }
    }
}