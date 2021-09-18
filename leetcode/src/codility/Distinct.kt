package codility

fun solution(A: IntArray): Int {
    A.sort()
    var i = 0
    var ans =0
    while(i<A.size){
        while(i < A.size-1 && A[i]==A[i+1])i++
        ans++
        i++
    }
    return ans
}