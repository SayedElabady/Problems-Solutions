import AprilChallenge.b
import kotlin.math.max
import kotlin.math.min

class Solution1105 {
    var answer = Int.MAX_VALUE
    fun minHeightShelves(books: Array<IntArray>, shelf_width: Int): Int {
        orderBooks(books, 0, 0, 0, shelf_width, shelf_width)
        return answer
    }

    fun orderBooks(
        books: Array<IntArray>, index: Int, currentHeight: Int, totalHeight: Int, widthLeft: Int, maxWidth: Int
    ) {
        if (index == books.size) {
            answer = min(answer, totalHeight)
            return
        }
        with(widthLeft - books[index][1]) {
            if (this > 0) {
                if (books[index][0] > currentHeight) {
                    orderBooks(
                        books,
                        index + 1,
                        books[index][0],
                        totalHeight + (books[index][0] - currentHeight),
                        this,
                        maxWidth
                    )
                } else {
                    orderBooks(
                        books,
                        index + 1,
                        currentHeight,
                        totalHeight,
                        this,
                        maxWidth
                    )
                }
            } else {
                orderBooks(
                    books,
                    index + 1,
                    books[index][1],
                    totalHeight + books[index][1],
                    maxWidth - books[index][0],
                    maxWidth
                )
            }
        }
    }
}

fun main() {
    
}