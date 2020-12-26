fun main() {
    val solution5 = Solution9()
    print(solution5.numTilePossibilities("AAB"))
}

class Solution9 {
    var hash = HashMap<String , Boolean>()
    var sum = 0

    fun numTilePossibilities(tiles: String): Int {
        get("" , tiles)
        return sum
    }

    fun get(value: String, tiles: String){
        for(i in 0 until tiles.length){
            if(hash.get(value + tiles[i]) == null){
                val remaining = tiles.substring(0 , i) + tiles.substring(i+1 , tiles.length)
                sum++
                hash[value + tiles[i]] = true
                get(value + tiles[i] , remaining)
            }
        }
    }


}