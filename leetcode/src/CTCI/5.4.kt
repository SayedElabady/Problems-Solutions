package CTCI

fun getNext(number: Int): Int{
    var zeroCounter = 0
    var onesCounter = 0
    var temp = number
    while ((temp.and(1) != 0) && onesCounter!=0){
        if(temp.and(1) == 0) zeroCounter++
        else onesCounter++
        temp = temp.shr(1)
    }
    val p = onesCounter + zeroCounter
    if (p>=32) return -1
    val a = 1.shl(p-1)
    val b = a - 1
    val mask = b.inv()
    var answer = number.and(mask)
    answer = answer.or(1.shl(p))

    answer = answer.or(1.shl(onesCounter - 1) - 1 )
return answer
}