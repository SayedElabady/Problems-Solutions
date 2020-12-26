package HackerRank

import kotlin.math.abs

fun main() {
    minimumBribes(arrayOf(2, 1, 5, 3, 4))
}

fun minimumBribes(q: Array<Int>): Unit {
    var doable = true
    val N = q.size
    var ans = 0
    for (i in N - 1 downTo 0) {
        if (q[i] != i + 1) {
            if ((i - 1) >= 0 && q[i - 1] == i + 1) {
                ans++
                q[i - 1] = q[i]
                q[i] = i + 1
            } else if ((i - 2) >= 0 && q[i - 2] == i + 1) {
                ans += 2
                q[i - 2] = q[i - 1]
                q[i - 1] = q[i]
                q[i] = i + 1
            }else {
                println("Too chaotic")
                return
            }
        }
    }

    println(ans)
}
