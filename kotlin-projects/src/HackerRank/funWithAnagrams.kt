package HackerRank

fun funWithAnagrams(text: Array<String>): Array<String> {
    val ans = arrayListOf<String>()
    text.forEach outer@{ newString ->
        ans.forEach inner@{
            if (isEqual(newString, it)) {
                return@outer
            }

        }
            ans.add(newString)
    }
    return ans.sorted().toTypedArray()
}

fun isEqual(firstString: String, secondString: String): Boolean {
    val sortedFirst = firstString.toCharArray().sorted()
    val sortedSecond = secondString.toCharArray().sorted()
    return sortedFirst.equals(sortedSecond)
}

fun main(args: Array<String>) {
    val textCount = readLine()!!.trim().toInt()

    val text = Array<String>(textCount, { "" })
    for (i in 0 until textCount) {
        val textItem = readLine()!!
        text[i] = textItem
    }

    val result = funWithAnagrams(text)

    println(result.joinToString("\n"))
}