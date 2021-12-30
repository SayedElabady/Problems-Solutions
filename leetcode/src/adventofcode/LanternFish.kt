package adventofcode

class LanternFish{

    fun calculate(input: MutableList<Int>, days: Int): Long{
        // zero old, 1 new
        val scores = Array(9){ LongArray(2) }
        input.forEach {
            scores[it][0]++
        }
        for (day in 0 until days){
            for (number in 8 downTo 0){
                if(number != 0){
                    scores[number-1][1] = scores[number][0]
                    scores[number][0] = scores[number][1]
                }else{
                    scores[6][0]+= scores[number][0]
                    scores[8][0]=scores[number][0]
                    scores[number][0] = scores[number][1]
                }
            }

//            scores.forEachIndexed {index, it->
//                print(" $index old: ${it[0]}, old: ${it[1]} - ")
//            }
//            println()
//            val listSize = input.size
//            for(index in 0 until listSize){
//                input[index]--
//                if(input[index] == -1){
//                    input[index] = 6
//                    input.add(8)
//                }
//            }
        }
        var answer: Long = 0L
        scores.forEach {
            answer+=it[0]
        }
        return answer
    }
}

fun main() {
    val s = LanternFish()
    print(s.calculate(mutableListOf(5,1,1,5,4,2,1,2,1,2,2,1,1,1,4,2,2,4,1,1,1,1,1,4,1,1,1,1,1,5,3,1,4,1,1,1,1,1,4,1,5,1,1,1,4,1,2,2,3,1,5,1,1,5,1,1,5,4,1,1,1,4,3,1,1,1,3,1,5,5,1,1,1,1,5,3,2,1,2,3,1,5,1,1,4,1,1,2,1,5,1,1,1,1,5,4,5,1,3,1,3,3,5,5,1,3,1,5,3,1,1,4,2,3,3,1,2,4,1,1,1,1,1,1,1,2,1,1,4,1,3,2,5,2,1,1,1,4,2,1,1,1,4,2,4,1,1,1,1,4,1,3,5,5,1,2,1,3,1,1,4,1,1,1,1,2,1,1,4,2,3,1,1,1,1,1,1,1,4,5,1,1,3,1,1,2,1,1,1,5,1,1,1,1,1,3,2,1,2,4,5,1,5,4,1,1,3,1,1,5,5,1,3,1,1,1,1,4,4,2,1,2,1,1,5,1,1,4,5,1,1,1,1,1,1,1,1,1,1,3,1,1,1,1,1,4,2,1,1,1,2,5,1,4,1,1,1,4,1,1,5,4,4,3,1,1,4,5,1,1,3,5,3,1,2,5,3,4,1,3,5,4,1,3,1,5,1,4,1,1,4,2,1,1,1,3,2,1,1,4),   256  ))
    //print(s.calculate(mutableListOf(3,4,3,1,2), 80 ))

}