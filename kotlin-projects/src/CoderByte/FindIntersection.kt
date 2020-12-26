package CoderByte

fun FindIntersection(strArr: Array<String>): String {
    val firstNumbersArray = strArr[0].split(",").map {

        it.trim().toInt()
    }
    val secondNumbersArray = strArr[1].split(",").map {
        it.trim().toInt()
    }

    var firstIndex = 0
    var secondIndex = 0
    val matchedNumbers = mutableListOf<Int>()
    while (firstIndex < firstNumbersArray.size && secondIndex < secondNumbersArray.size) {
        when {
            firstNumbersArray[firstIndex] == secondNumbersArray[secondIndex] -> {
                matchedNumbers.add(firstNumbersArray[firstIndex])
                firstIndex++
                secondIndex++
            }
            firstNumbersArray[firstIndex] < secondNumbersArray[secondIndex] -> firstIndex++
            else -> secondIndex++
        }
    }
    if (matchedNumbers.isEmpty())
        return "false"

    return matchedNumbers.joinToString(separator = ",")
}

fun main(args: Array<String>) {
    println(FindIntersection(arrayOf("1, 3, 9, 10, 17, 18", "1, 4, 9, 10")
    ))
}