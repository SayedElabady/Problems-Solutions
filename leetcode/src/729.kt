class MyCalendar() {
    val periods = mutableListOf<Pair<Int, Int>>()

    fun book(start: Int, end: Int): Boolean {
        periods.forEach {
            if ((start >= it.first && start <= it.second) ||
                (end - 1 >= it.first && end - 1 <= it.second) ||
                (start < it.first && end > it.second)
            )
                return false
        }
        periods.add(Pair(start, end - 1))
        return true
    }

}

fun main() {
    val calendar = MyCalendar()
    println(calendar.book(97, 100))
    println(calendar.book(33, 51))
    println(calendar.book(75, 92))
    println(calendar.book(19, 30))
    println(calendar.book(53, 63))
    println(calendar.book(13, 32))

}