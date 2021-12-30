package CTCI

import kotlin.math.max

fun flipBit(number: Int): Int{
    var temp = number
    var currentSeq = 0
    var prev = 0
    var maxx = 0
    while (temp != 0){
        if(temp.and(1) == 1){
            currentSeq++
        }else{
            if(temp.and(2) == 0){
                prev = 0
            }else{
                prev = currentSeq+1
                currentSeq = 0
            }
        }
        maxx = max(maxx, currentSeq + prev)
        temp = temp.shr(1)
    }
    return maxx
}

fun main() {
    print(flipBit(1775))
}