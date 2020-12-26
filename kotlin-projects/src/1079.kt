fun main() {
    val solution5 = Solution8()
    print(solution5.numTilePossibilities("AAB"))
}

class Solution8 {
    var hash = HashMap<String, Boolean>()
    var sum = 0

    fun numTilePossibilities(tiles: String): Int {
        var charCount = IntArray(26) { 0 }
        for (i in 0 until tiles.length) ++charCount[tiles[i] - 'A']

        get("", tiles, charCount)
        return sum
    }

    fun get(value: String, tiles: String, charCount: IntArray) {
        if (value.length == tiles.length) return
        for (i in 0 until tiles.length) {
            if (charCount[tiles[i] - 'A'] == 0) {

            }
            else {
                val concated = value + tiles[i]
                if (hash[concated] == null) {
                    hash[concated] = true
                    sum++
                    --charCount[tiles[i] - 'A']
                    get(concated, tiles, charCount)
                    ++charCount[tiles[i] - 'A']
                }
            }
        }
    }

}