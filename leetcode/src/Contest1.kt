fun main(){
    val s = Solutionss()
    val first = IntArray(50) { 0 }
    val second = IntArray(50) { 0 }
    val matrix = arrayOf(first, second)

    print(matrix.size)

}

class Solutionss {


    fun oddCells(n: Int, m: Int, indices: Array<IntArray>): Int {
        val first = IntArray(50) { 0 }
        val second = IntArray(50) { 0 }
        val matrix = arrayOf(first, second)
        for (i in 0 until indices.size){
            for(row in 0 until matrix.get(0).size)  matrix[indices[i][0]][row] +=1
            for(row in 0 until matrix.get(0).size)  matrix[row][indices[0][i]]
        }
        var ans = 0
        for(row in 0 until n){
            for(col in 0..m)
                if(matrix[row][col] % 2 ==1) ans++
        }
        return ans
    }

}