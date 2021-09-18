class Solution1306 {

    fun canReach(arr: IntArray, start: Int): Boolean {
        return check(start, arr, BooleanArray(arr.size + 1))
    }

    fun check(index: Int, arr: IntArray, visited: BooleanArray): Boolean {
        visited[index] = true
        var rightValue = false
        if (index + arr[index] < arr.size && !visited[index + arr[index]])
            rightValue = check(index + arr[index], arr, visited)
        var leftValue = false
        if (index - arr[index] >= 0 && !visited[index - arr[index]])
            leftValue = check(index - arr[index], arr, visited)
        return arr[index] == 0 || leftValue || rightValue
    }
}

fun main() {
    val s = Solution1306()
    s.canReach(intArrayOf(4, 2, 3, 0, 3, 1, 2), 5)
    s.canReach(intArrayOf(3,0,2,1,2), 2)

}