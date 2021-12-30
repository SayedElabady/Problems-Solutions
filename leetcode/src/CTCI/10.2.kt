package CTCI

fun sortStrings(stringsList: List<String>): List<String> {
    val map = HashMap<String, MutableList<String>>()
    stringsList.forEach {
        val sortedString = it.toSortedSet().toString()
        val savedValues = map.get(sortedString)
        if (savedValues == null) {
            map[sortedString] = mutableListOf(it)
        } else {
            savedValues.add(it)
            map[sortedString] = savedValues
        }
    }
    val answer = mutableListOf<String>()
    map.forEach {
        it.value.forEach {
            answer.add(it)
        }
    }
    return answer.toList()
}

fun main() {
    sortStrings(listOf("sayed", "ahmed", "saeyd", "amhed"))
}