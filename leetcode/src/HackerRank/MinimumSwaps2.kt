package HackerRank


fun main() {
    minimumSwaps(arrayOf(4, 3, 1, 2))
}

fun minimumSwaps(arr: Array<Int>): Int {
    val occurnces = Array<Int>(arr.size) { 0 }
    for (i in arr.indices) {
        arr[i]--
        occurnces[arr[i]] = i
    }
    var ans = 0
    for (i in arr.indices) {
        if (arr[i] == i) continue
        ans++
        val temp = arr[i]
        arr[i] = i
        arr[occurnces[arr[i]]] = temp
        val indexTemp = occurnces[i]
        occurnces[i] = i
        occurnces[temp] = indexTemp
    }
    return ans
}