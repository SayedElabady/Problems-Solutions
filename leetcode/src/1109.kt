class Solution1109 {
    fun corpFlightBookings(bookings: Array<IntArray>, n: Int): IntArray {
        val seats = IntArray(n+2)
        bookings.forEach {
            seats[it[0]-1]+=it[2]
            seats[it[1]]-=it[2]
        }
        for (index in 1 until seats.size){
            seats[index]+=seats[index-1]
        }
        return seats.copyOfRange(1,n+2)
    }
}