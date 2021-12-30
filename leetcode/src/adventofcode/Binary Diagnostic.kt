package adventofcode

fun binaryDiagnostic(input: List<String>): Long {
    var gamma = 0
    var epsilon = 0
    var firstNumber: String=""
    var secondNumber: String =""
    for (index in 0 until input[0].length) {
        val lst =getOx(input, index)
        if(lst.size==1){
            firstNumber = lst[0]
            break
        }
    }
    for (index in 0 until input[0].length) {
        val lst =getCO(input, index)
        if(lst.size==1){
            secondNumber = lst[0]
            break
        }
    }

    return getNumber(firstNumber) * getNumber(secondNumber)
}
fun getNumber(string: String): Long{
    var number = 0L
    var multuipler = 1
    string.reversed().forEach {
        if(it=='1') number+=multuipler
        multuipler *= 2
    }
    return number
}

fun getOx(input: List<String>, startIndex: Int ): List<String>{
    var newList = input
    for (index in startIndex until input[0].length) {
        if(newList.size == 1) return newList
        val zeroesList = mutableListOf<String>()
        val onesList = mutableListOf<String>()
        newList.forEach {
            if (it[index] == '1') {
                onesList.add(it)
            } else {
                zeroesList.add(it)
            }
        }
        newList = if (onesList.size >= zeroesList.size) {
            onesList
        } else {
            zeroesList
        }
    }
    return newList
}

fun getCO(input: List<String>, startIndex: Int ): List<String>{
    var newList = input
    for (index in startIndex until input[0].length) {
        if(newList.size == 1) return newList
        val zeroesList = mutableListOf<String>()
        val onesList = mutableListOf<String>()
        newList.forEach {
            if (it[index] == '1') {
                onesList.add(it)
            } else {
                zeroesList.add(it)
            }
        }
        newList = if (zeroesList.size > onesList.size) {
            onesList
        } else {
            zeroesList
        }
    }
    return newList
}

fun main() {
    var line: String? = readLine()
    val list = mutableListOf<String>()
    while (line != null && line.isNotEmpty()) {
        list.add(line)
        line = readLine()
    }
    println(binaryDiagnostic(list))
}