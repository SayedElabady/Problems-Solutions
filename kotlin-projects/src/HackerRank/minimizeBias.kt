package HackerRank


fun minimizeBias(ratings: Array<Int>): Int {
    // Write your code here
    ratings.sort()
    var ans = 0
    for (i in 0 until ratings.size step 2){
        ans += ratings[i+1] - ratings[i]
    }
    return ans
}

fun main(args: Array<String>) {
    val ratingsCount = readLine()!!.trim().toInt()

    val ratings = Array<Int>(ratingsCount, { 0 })
    for (i in 0 until ratingsCount) {
        val ratingsItem = readLine()!!.trim().toInt()
        ratings[i] = ratingsItem
    }

    val result = minimizeBias(ratings)

    println(result)
}
