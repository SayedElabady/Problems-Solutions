class Solution659 {
    fun isPossible(nums: IntArray): Boolean {
        val occurances = HashMap<Int, Int>()
        val items = mutableListOf<Int>()
        items.add(nums[0])
        nums.forEach{
            if(items.last()!! != it) items.add(it)
            occurances[it] = occurances.getOrDefault(it, 0) + 1
        }
        var currentIndex = 0
        while(true){
            if(currentIndex == items.size) return true
            var index = 1
            var requiredValue = items[currentIndex]
            val requiredAmount = occurances[requiredValue]
            occurances[requiredValue] = 0

            while(index + currentIndex < items.size){
                if(items[currentIndex + index] - requiredValue != 1) break
                if(occurances[items[currentIndex + index]]!!<requiredAmount!!) break
                if(occurances[items[currentIndex + index]]!! > requiredAmount!! && index >=2){
                    occurances[items[currentIndex + index]] = occurances[items[currentIndex + index]]!!.minus( requiredAmount)
                    break
                }
                occurances[items[currentIndex + index]] = occurances[items[currentIndex + index]]!!.minus( requiredAmount)
                requiredValue++
                index++
            }
            if(index < 2) return false
            while(currentIndex<items.size && occurances[items[currentIndex]]==0)currentIndex++
        }
        return true
    }
}

fun main() {
    val s = Solution659()
    s.isPossible(intArrayOf(1,2,3,4,4,5))
}