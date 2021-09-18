package Algo1

class Solution77 {
    val answer = mutableListOf<List<Int>>()
    fun combine(n: Int, k: Int): List<List<Int>> {
        backtrack(1,n,k, mutableListOf())
        return answer
    }

    fun backtrack(currentNumber: Int, maxValue: Int, limit: Int, total: MutableList<Int>){
        if(total.size == limit) {

            answer.add(total)
            return
        }
        (currentNumber+1..maxValue).forEach {
            val copy = total.toMutableList()
            copy.add(currentNumber)
            backtrack(it, maxValue,limit,copy)
            backtrack(it, maxValue,limit,total)
        }
    }

    fun stringToNumList(total : String): List<Int>{
        val result = mutableListOf<Int>()
        total.forEach {
            result.add(it.toString().toInt())
        }
        return result
    }
}

