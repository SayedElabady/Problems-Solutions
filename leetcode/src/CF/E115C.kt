package CF

    import kotlin.math.abs


fun main() {
    val tests = readLine()!!.toInt()
    for (test in 0 until tests) {
        val n = readLine()!!.toInt()
        val occurences = HashMap<Long, MutableList<Int>>()
        var itemsSum = 0L
        val items = readLine()!!.split(" ").mapIndexed { index, it ->
            itemsSum += it.toLong()
            occurences[it.toLong()] = occurences.getOrDefault(it.toLong(), mutableListOf()).apply {
                this.add(index)
            }
            it.toInt()
        }

        if((itemsSum * 2) % n != 0L) {
            println(0)
            continue
        }

        val diff = (itemsSum * 2) / n
        var answer = 0L
        items.forEachIndexed { index, it ->
            if (occurences.containsKey(diff - it)) {
                val occ = occurences[diff - it]
                val lowerBoundIndex = occ!!.binarySearch(index).run {
                    if(this < 0) abs(this) - 1
                    else this
                }

                if(lowerBoundIndex < occ.size){
                    answer += occ.size - lowerBoundIndex
                    if(occ[lowerBoundIndex] == index)
                    answer -= 1
                }
                else if(lowerBoundIndex + 1 < occ.size && occ[lowerBoundIndex + 1] > index){
                    answer += occ.size - lowerBoundIndex
                }
            }
        }
        println(answer)
    }
}