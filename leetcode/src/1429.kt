import codility.canadaTest.First
import java.util.*
import kotlin.collections.HashMap
import kotlin.collections.LinkedHashMap

class FirstUnique(nums: IntArray) {

    val occs = LinkedHashMap<Int, Int>()
    val uniqueNumbers = ArrayDeque<Int>()

    init {
        nums.forEach{
            val valueOccurrence = occs.get(it)
            if(valueOccurrence == null){
                occs[it] = 1
            }else{
                occs[it] = valueOccurrence + 1
            }
            //occs[it] = occs.getOrDefault(it, 0) + 1
        }
        occs.forEach{
            if(it.value == 1)
                uniqueNumbers.add(it.key)
        }
    }

    fun showFirstUnique(): Int {
        while(!uniqueNumbers.isEmpty() && occs[uniqueNumbers.first()]!! > 1) uniqueNumbers.removeFirst()
        if(uniqueNumbers.isEmpty()) return -1
        return uniqueNumbers.first()
    }

    fun add(value: Int) {
        val valueOccurence = occs.get(value)
        if(valueOccurence == null){
            occs[value] = 1
            uniqueNumbers.add(value)
        }else{
            occs[value] = valueOccurence+1
        }
    }

}

/**
 * Your FirstUnique object will be instantiated and called as such:
 * var obj = FirstUnique(nums)
 * var param_1 = obj.showFirstUnique()
 * obj.add(value)
 */
fun main() {
  //  val s = FirstUnique(intArrayOf(698,866,349,680,733,916,961,652,161,960,417,813,474,170,802,406,442,454,780,886,899,367,786,157,953,621,29,273,485,55,563,275,343,157,715,683,608,932,874,241,796,877,845,26,719,167,415,287,411,95,196,118,291,811,969,27,805,323,707,625,651,588,445,690,706,694,317,978,327,764,366,18,104,753,791,94,912,171,923,969,457,717,694,147,329,12,84,650,592,383,506,924,939,495,999,120,529,117,446,830,740,108,791,518,83,164,606,172,783,808))
    val s = FirstUnique(intArrayOf(2,3,5))
    print(s.showFirstUnique())
}

