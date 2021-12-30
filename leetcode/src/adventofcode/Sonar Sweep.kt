package adventofcode


fun getIncrementNumbers(input: List<Int>): Int{
//    var start = Int.MAX_VALUE
//    var answer = 0
//    input.forEach {
//        if(it > start){
//            answer++
//        }
//        start = it
//    }
//return answer
    val newList = mutableListOf<Int>()
    for (index in 0 until input.size - 2){
        var sum = 0
        for(iterator in index until index+3){
            sum+=input[iterator]
        }
        newList.add(sum)
    }
        var start = Int.MAX_VALUE
    var answer = 0
    newList.forEach {
        if(it > start){
            answer++
        }
        start = it
    }
return answer
}

fun main() {
    var line: String? = readLine()
    val list = mutableListOf<Int>()
    while (line != null && line.isNotEmpty()){
        list.add(line.toInt())
        line = readLine()
    }
    println(getIncrementNumbers(list))
}