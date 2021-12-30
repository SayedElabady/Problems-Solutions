package CTCI

import java.util.*

fun checkDuplicate(array: IntArray){
    val bitSet = BitSet(32000)
    array.forEach {
        if(bitSet.get(it-1)){
            println(it)
        }else{
            bitSet.set(it-1)
        }
    }
}

fun main() {
    checkDuplicate(intArrayOf(5,9,8,6,32000,32000,5))
}
