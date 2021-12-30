package CTCI

val coins = intArrayOf(50, 25, 10)

fun makeChange(amount: Int) : Int{
    val memo = Array(amount+2) { IntArray(3){-1} }
    return iterate(amount, 0, memo)
}

fun iterate(amountLeft : Int, index: Int, memo :Array<IntArray>): Int{
    if(amountLeft == 0) return 1
    if(index > 2) return 0
    if(memo[amountLeft][index] != -1) return memo[amountLeft][index]
    var currentAmount = amountLeft
    memo[amountLeft][index] = 0
    while (currentAmount >= coins[index]){
        memo[amountLeft][index] += iterate(currentAmount - coins[index], index+1, memo)
        currentAmount -= coins[index]
    }
    memo[amountLeft][index] += iterate(amountLeft, index+1, memo)
    return memo[amountLeft][index]
}

fun main() {
    print(makeChange(50))
}