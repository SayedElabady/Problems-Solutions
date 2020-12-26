import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextLong()
    val fibs = MutableList<Long>((n + 1).toInt()) { 0 }
    if (n == 0L) return println(0)
    fibs[0] = 1
    fibs[1] = 1
    for (a in 2..n)
        fibs[a.toInt()] = fibs[(a - 1).toInt()] + fibs[(a - 2).toInt()]

    println(fibs[(n - 1).toInt()])
}