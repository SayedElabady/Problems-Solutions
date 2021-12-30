package adventofcode


class SevenSegmentSearch{

    fun sevenSegmentSearch(input: List<String>): Int{
//    val eq = intArrayOf(0,3,21,16,14,20,27,7,28,21)
//    var answer = 0
//    input.forEach {
//        val patterns
//        var number = 0
//        it.split("|")[1].split(" ").filter { it != "" }.forEach {dum ->
//            var sum = 0
//            dum.forEach {
//                sum += it - 'a'
//                sum++
//            }
//             val digit =
//            if (sum == 21){
//                if(dum.contains("e"))2
//                else 9
//            }else eq.indexOf(sum)
//            number = (number * 10) + digit
//        }
//        answer +=number
//    }
//    return answer

        var answer = 0
        input.forEach {
            val patterns = HashMap<String, Int>()
            val zeroGroup = mutableListOf<String>()
            val twoGroup = mutableListOf<String>()

            it.split("|")[0].split(" ").filter { it != "" }.forEach {string ->
                val array = string.toCharArray().sorted()
                when {
                    array.size == 2 -> patterns[array.joinToString("")] = 1
                    array.size == 4 -> patterns[array.joinToString("")] = 4
                    array.size == 3 -> patterns[array.joinToString("")] = 7
                    array.size == 7 -> patterns[array.joinToString("")] = 8
                    array.size == 6 -> zeroGroup.add(array.joinToString(""))
                    else -> twoGroup.add(array.joinToString(""))
                }
            }
            zeroGroup.forEach {
                when {
                    it.contains1(patterns.filterValues { it == 4 }.keys.first()) -> patterns[it] = 9
                    it.contains1(patterns.filterValues { it == 1 }.keys.first()) -> patterns[it] = 0
                    else -> patterns[it] = 6
                }
            }
            twoGroup.forEach {
                val four = patterns.filterValues { it == 4 }.keys.first()
                when {
                    it.contains1(patterns.filterValues { it == 7 }.keys.first()) -> patterns[it] = 3
                    it.count { char -> four.contains(char) } == 2 -> patterns[it] = 2
                    else -> patterns[it] = 5
                }
            }
            var number = 0
            it.split("|")[1].split(" ").filter { it != "" }.forEach {dum ->
                val digitString = dum.toCharArray().sorted().joinToString("")
                number = (number * 10) + patterns[digitString]!!
            }
            answer +=number
        }
        return answer
    }

    fun String.contains1(string2: String): Boolean{
        return this.count { char -> string2.contains(char) } == string2.length
    }
}

fun main() {
    var line: String? = readLine()
    val list = mutableListOf<String>()
    while (line != null && line.isNotEmpty()){
        list.add(line)
        line = readLine()
    }
    val s = SevenSegmentSearch()
    println(s.sevenSegmentSearch(list))
}
