import java.lang.StringBuilder

class BiWeekly66B {
    fun minimumBuckets(street: String): Int {
        val houesesIndices = mutableListOf<Int>()
        if (street.length == 1) {
            return if (street[0] == 'H') -1
            else 0
        }
        var builder = StringBuilder(street)
        street.forEachIndexed { index, it ->
            if (it == 'H') {
                houesesIndices.add(index)
                if (index == 0) {
                    if (street[1] == 'H') return -1
                } else if (street[index - 1] == 'H' && index + 1 < street.length && street[index + 1] == 'H') return -1
            }
        }
        var answer = 0
        houesesIndices.forEach {
            if(it ==0){
                builder[1] = 'B'
                answer++
            }else{
                if(builder[it-1]=='B' || (it<builder.length && builder[it+1]=='B')){

                }else {
                    if(it+1<builder.length){
                        builder[it+1]='B'
                    }else{
                        builder[it-1]='B'
                    }
                    answer++
                }
            }
        }
        return answer
    }

}

fun main() {
    val s = BiWeekly66B()

}