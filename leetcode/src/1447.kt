class Solution1447 {
    fun simplifiedFractions(n: Int): List<String> {
        val visitedFractions = mutableListOf<Double>()
        val answer = mutableListOf<String>()
        for (previousNumber in 2..n) {
            for (fraction in 1 until previousNumber) {
                if (!visitedFractions.contains(fraction.toDouble() / previousNumber.toDouble())){
                    visitedFractions.add(fraction.toDouble() / previousNumber.toDouble())
                    answer.add("$fraction/$previousNumber")
                }
            }
        }
        return answer
    }

}

fun main() {
    val s = Solution1447()
    println(System.currentTimeMillis())
    println(s.simplifiedFractions(100))
    println(System.currentTimeMillis())
}