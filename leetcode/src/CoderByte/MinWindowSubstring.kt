package CoderByte

fun MinWindowSubstring(strArr: Array<String>): String {

    val requiredOccurrences = IntArray(28)
    var initialAnswer = strArr[0]
    strArr[1].forEach {
        requiredOccurrences[it - 'a']++
    }
    for (outerIndex in 0 until strArr[0].length) {
        for (innerIndex in outerIndex + strArr[1].length until strArr[0].length) {
            val currentSubString = strArr[0].substring(outerIndex, innerIndex)
            if (checkIfApplicable(currentSubString, requiredOccurrences))
                if (currentSubString.length < initialAnswer.length)
                    initialAnswer = currentSubString
        }
    }
    return initialAnswer

}

fun checkIfApplicable(subString: String, requiredOccurences: IntArray): Boolean {
    val currentOccurences = IntArray(28)
    subString.forEach { currentOccurences[it - 'a']++ }
    currentOccurences.forEachIndexed { index, element ->
        if (requiredOccurences[index] > element)
            return false
    }
    return true
}

fun main(args: Array<String>) {
    println(MinWindowSubstring(arrayOf("ahffaksfajeeubsne", "jefaa")))
}