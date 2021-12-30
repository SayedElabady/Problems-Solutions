package adventofcode

fun dive(list: MutableList<Pair<String, Int>>): Long{
    var depth = 0L
    var hPosition = 0L
    var aim =0L
    list.forEach {
        if(it.first == "forward"){
            hPosition+=it.second
            depth += aim * it.second
        }else if(it.first == "up"){
            aim -= it.second
        }else{
            aim +=it.second
        }
    }
    return depth*hPosition
}

fun main() {
    var line: String? = readLine()
    val list = mutableListOf<Pair<String, Int>>()
    while (line != null && line.isNotEmpty()){

        list.add(line.split(" ")[0] to line.split(" ")[1].toInt())
        line = readLine()
    }
    println(dive(list))
}