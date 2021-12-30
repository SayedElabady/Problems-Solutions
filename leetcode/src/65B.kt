class Robot(val width: Int, val height: Int) {
    var x = 0
    var y = 0
    // 0 -> East, 1-> North, 2-> West, 3-> South
    var direction = 0

    fun move(num: Int) {
        doIterations(num % ((2 * width + 2 * height) - 4))
        
    }

    fun getPos(): IntArray {
        return intArrayOf(x, y)
    }

    fun getDir(): String {
        return when (direction) {
            0 -> "East"
            1 -> "North"
            2 -> "West"
            else -> "South"
        }
    }

    fun doIterations(iterations: Int) {
        if(iterations == 0 && direction == 0) direction = 3
        for (iteration in 0 until iterations){
            changeDirection()
            when (direction) {
                0 -> x++
                1 -> y++
                2 -> x--
                3 -> y--
            }
            x%=width
            y%=height
        }
    }

    fun changeDirection() {
        if (x == width - 1 && direction == 0) {
            direction = 1
        } else if (y == height - 1 && direction == 1) {
            direction = 2
        } else if (x == 0 && direction == 2) {
            direction = 3
        } else if (y == 0 && direction == 3) {
            direction = 0
        }
    }

}

fun main() {
    val s = Robot(2, 2)
    s.move(12)
    println(s.getDir())
    s.getPos().forEach { print( "$it  ") }
    s.move(21)
    println(s.getDir())
    s.getPos().forEach { print( "$it  ") }
    s.move(17)
    println(s.getDir())
    s.getPos().forEach { print( "$it  ") }
    println(s.getDir())
    s.getPos().forEach { print( "$it  ") }

}