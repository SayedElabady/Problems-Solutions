class Solution52 {
    val placment = Array(9){BooleanArray(9){false}}
    val occColumns = BooleanArray(9){ false }
    var answer = 0
    fun totalNQueens(n: Int): Int {
        tryPlacement(0, 0, n)
        return answer
    }

    fun tryPlacement(row: Int, count: Int, n: Int){
        if(count == n){
            answer++
            return
        }
        if(row == n){
            return
        }

        for(index in 0 until n){

            if(canPlace(row, index)){
                place(row, index, n)

                tryPlacement(row+1, count+1, n)
                removePlacement(row, index,n)
            }
        }

    }

    fun canPlace(row: Int, col: Int) = !placment[row][col] && !occColumns[col]

    fun place(row:Int, col: Int, n:Int){
        occColumns[col] = true
        var rowIndex = row
        var colIndex = col
        while(colIndex >=0 && rowIndex < n){
            placment[rowIndex++][colIndex--] = true
        }
        rowIndex = row
        colIndex = col
        while(colIndex < n && rowIndex < n){
            placment[rowIndex++][colIndex++] = true
        }
        rowIndex = row
        colIndex = col
        while(colIndex < n && rowIndex >= 0 ){
            placment[rowIndex--][colIndex++] = true
        }
        rowIndex = row
        colIndex = col
        while(colIndex >=0 && rowIndex >= 0 ){
            placment[rowIndex--][colIndex--] = true
        }
    }

    fun removePlacement(row: Int, col: Int, n: Int){
        occColumns[col] = false
        var rowIndex = row
        var colIndex = col
        while(colIndex >=0 && rowIndex < n){
            placment[rowIndex++][colIndex--] = false
        }
        rowIndex = row
        colIndex = col
        while(colIndex < n && rowIndex < n){
            placment[rowIndex++][colIndex++] = false
        }
        rowIndex = row
        colIndex = col
        while(colIndex < n && rowIndex >= 0 ){
            placment[rowIndex--][colIndex++] = false
        }
        rowIndex = row
        colIndex = col
        while(colIndex >=0 && rowIndex >= 0 ){
            placment[rowIndex--][colIndex--] = false
        }
    }

}

fun main() {
    val s = Solution52()
    s.totalNQueens(4)
}