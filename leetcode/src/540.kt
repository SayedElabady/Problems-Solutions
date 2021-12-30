class Solution540{
    fun singleNonDuplicate(nums: IntArray): Int {
        return binarySearch(nums)
    }

    fun binarySearch(array: IntArray): Int{
        var left = 0
        var right = array.size - 1
        while(left < right){
            val mid = left + (right - left) / 2
            val midValue = array[mid]
            if(mid-1>=0 && array[mid-1] != midValue && mid+1 < array.size && array[mid+1] != midValue) return midValue
            else if(mid - 1 >= 0 && array[mid-1] == midValue){
                if((mid-1) % 2 == 0){
                    left = mid + 1
                }else {
                    right = mid - 1
                }
            }else{
                if((mid) % 2 == 0){
                    left = mid + 1
                }else {
                    right = mid - 1
                }
            }
        }
        return array[left]
    }

}

fun main() {
    val s = Solution540()
    s.singleNonDuplicate(intArrayOf(1,1,2,3,3,4,4,8,8))

    s.singleNonDuplicate(intArrayOf(3,3,7,7,10,11,11))
}